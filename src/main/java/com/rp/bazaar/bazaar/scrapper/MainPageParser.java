package com.rp.bazaar.bazaar.scrapper;

import org.jsoup.nodes.Document;

/**
 * Parse main page from bazaar and retrieve metadata about page:
 * - all possible searching criteria
 * - number of pages
 * - number of actions per page
 * @author Radoslaw Piwowarski
 */
class MainPageParser {

    static MainPageRecord parse(Document document) {
        return MainPageRecord.empty();
    }
}
