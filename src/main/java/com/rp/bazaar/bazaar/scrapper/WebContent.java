package com.rp.bazaar.bazaar.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Download web content
 * @author Radoslaw Piwowarski
 */
class WebContent {
    private static final Logger logger = LoggerFactory.getLogger(WebContent.class);

    private URL url;

    public static WebContent getInstance(String address) throws MalformedURLException, URISyntaxException {
        return new WebContent(address);
    }

    Document getDocument() {
        return document;
    }

    private Document document;

    private WebContent(String url) throws URISyntaxException, MalformedURLException {
        this.url = new URI(url).toURL();
    }

    void get() {
        try {
            document = Jsoup.connect(String.valueOf(url)).get();
        } catch (IOException e) {
            logger.info("Could not connect to website");
        }
    }
}
