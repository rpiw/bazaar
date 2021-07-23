package com.rp.bazaar.bazaar.scrapper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parse main page from bazaar and retrieve metadata about page:
 * - all possible searching criteria
 * - number of pages
 *
 * @author Radoslaw Piwowarski
 */
class MainPageParser {
    private static final Logger logger = LoggerFactory.getLogger(MainPageParser.class);
    private static final CharSequence LAST_PAGE = "Last Page";
    private static final String CURRENT_PAGE = "currentpage";

    private MainPageParser() {
    }

    static MainPageRecord parse() {
        MainPageRecord mainPageRecord;

        logger.info("Attempting to parse a document...");
        var mainPageScrapper = new MainPageScrapper();
        mainPageScrapper.get(); //connecting to network
        var content = mainPageScrapper.getContent();

        if (content == null) {
            logger.error("Nothing to parse, cya!");
            mainPageRecord = MainPageRecord.empty();
        } else {
            var criteria = findAllCriteria(content);
            var subpages = findSubpages(content);
            mainPageRecord = new MainPageRecord(criteria, subpages);
        }

        return mainPageRecord;
    }

    private static Subpages findSubpages(Document content) {
        logger.debug("Search for number of pages");
        var link = content.select("a[href]");
        var lastPage = link.stream()
                .filter(element -> element.text().contains(LAST_PAGE))
                .collect(Collectors.toList());
        Subpages subpages;
        if (!lastPage.isEmpty()) {
            subpages = getSubpages(lastPage);
        } else {
            subpages = new Subpages(0);
        }
        return subpages;
    }

    private static Subpages getSubpages(List<Element> lastPage) {
        try {
            var url = new URL(lastPage.get(0).attr("href"));
            var query = UriComponentsBuilder.fromHttpUrl(url.toString()).build().getQueryParams();
            logger.debug("Query parameters are {}", query);
            return new Subpages(Integer.parseInt(query.get(CURRENT_PAGE).get(0)));
        } catch (MalformedURLException e) {
            logger.error("Could not find a proper url!");
        }
        return new Subpages(0);
    }

    private static Criteria findAllCriteria(Document content) {
        var elements = content.select(Selection.getTAG());
        logger.debug("Search for criteria");

        var criteria = Criteria.empty();

        for (Element element : elements) {
            var selection = new Selection(element.className(), element.text(), new ArrayList<>());
            var values = element.getElementsByTag(Value.getTag());

            for (Element value : values) {
                var number = value.val();
                var valueContent = value.text();

                var newValue = new Value(number, valueContent);
                selection.addValue(newValue);
            }
            criteria.addSelection(selection);
        }
        return criteria;
    }
}
