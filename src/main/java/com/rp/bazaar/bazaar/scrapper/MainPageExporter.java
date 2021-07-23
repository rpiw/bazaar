package com.rp.bazaar.bazaar.scrapper;

public class MainPageExporter {
    public static MainPageRecord getMainPage() {
        return MainPageParser.parse();
    }
}
