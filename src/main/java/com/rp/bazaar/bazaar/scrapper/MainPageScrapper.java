package com.rp.bazaar.bazaar.scrapper;

import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

class MainPageScrapper {
    private static final Logger logger = LoggerFactory.getLogger(MainPageScrapper.class);

    Document getContent() {
        return content;
    }

    private Document content;

    void get() {
        try {
            var mainContent = WebContent.getInstance(URLTargets.CURRENT_ACTIONS.url);
            mainContent.get();

            content = mainContent.getDocument();

        } catch (MalformedURLException | URISyntaxException e) {
            logger.error("Could not connect to main page!");
        }
    }

}
