package com.rp.bazaar.bazaar.scrapper;

record MainPageRecord(Criteria criteria, Subpages subpages) {
    static MainPageRecord empty() {
        return new MainPageRecord(Criteria.empty(), new Subpages(0));
    }
}
