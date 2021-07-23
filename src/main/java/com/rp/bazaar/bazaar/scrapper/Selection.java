package com.rp.bazaar.bazaar.scrapper;

import java.util.ArrayList;

/**
 * Represent a "select" tag in HTML
 */
record Selection(String className, String name, ArrayList<Value> values) { //list must be a mutable
    private static final String TAG = "select";

    static String getTAG() {
        return TAG;
    }

    void addValue(Value value) {
        values.add(value);
    }
}
