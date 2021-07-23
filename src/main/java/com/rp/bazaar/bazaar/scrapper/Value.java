package com.rp.bazaar.bazaar.scrapper;

/**
 * Represent a "option" tag in HTML
 */
 record Value(String value, String content) {
    private static final String TAG = "option";

     static String getTag() {
        return TAG;
    }
}
