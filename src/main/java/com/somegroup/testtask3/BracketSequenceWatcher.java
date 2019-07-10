package com.somegroup.testtask3;

public class BracketSequenceWatcher {

    private final String query;
    private final boolean isNormalized;

    public BracketSequenceWatcher(String query, boolean isNormalized) {
        this.query = query;
        this.isNormalized = isNormalized;
    }

    public boolean getIsNormalized() {
        return isNormalized;
    }

    public String getQuery() {
        return query;
    }
}