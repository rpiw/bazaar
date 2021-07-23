package com.rp.bazaar.bazaar.scrapper;

enum URLTargets {
    CURRENT_ACTIONS("https://www.tibia.com/charactertrade/?subtopic=currentcharactertrades"),
    HISTORY("https://www.tibia.com/charactertrade/?subtopic=pastcharactertrades")
    ;
    public final String url;

    private URLTargets(String url) {
        this.url = url;
    }
}
