package com.incubyte.tdd;

public class UnsupportedNumberException extends Exception {

    public static final String NEGATIVES_NOT_ALLOWED = "Negatives not allowed: ";

    public UnsupportedNumberException(String message, int number) {
        super(message + number);
    }
}
