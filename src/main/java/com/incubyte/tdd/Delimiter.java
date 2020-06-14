package com.incubyte.tdd;

public class Delimiter {
    private static final Delimiter defaultDelimiter = new Delimiter("[\n,]", true);
    private String delimiter;
    private boolean isDefault;

    private Delimiter(String delimiter, boolean isDefault) {
        this.delimiter = delimiter;
        this.isDefault = isDefault;
    }

    public static Delimiter getDefaultDelimiter() {
        return defaultDelimiter;
    }

    public static Delimiter getDelimiterFor(String delimiter) {
        return new Delimiter(delimiter, false);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public boolean isDefault() {
        return isDefault;
    }
}