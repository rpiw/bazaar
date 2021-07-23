package com.rp.bazaar.bazaar.scrapper;

import java.util.ArrayList;
import java.util.List;

public class Criteria {

    private List<Selection> selections = new ArrayList<>();

    static Criteria empty() {
        return new Criteria();
    }
}
