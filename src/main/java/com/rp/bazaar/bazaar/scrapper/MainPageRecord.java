package com.rp.bazaar.bazaar.scrapper;

record MainPageRecord(Criteria criteria, Subpages subpages, AuctionsPerPage auctionsPerPage) {
    static MainPageRecord empty() {
        return new MainPageRecord(Criteria.empty(), new Subpages(0), new AuctionsPerPage(0));
    }
}
