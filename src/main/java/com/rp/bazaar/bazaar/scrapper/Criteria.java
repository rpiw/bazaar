package com.rp.bazaar.bazaar.scrapper;

import java.util.ArrayList;
import java.util.List;

class Criteria {

    void addSelection(Selection selection) {
        selections.add(selection);
    }

    private final List<Selection> selections = new ArrayList<>();

    static Criteria empty() {
        return new Criteria();
    }
}
