package com.incubyte.tdd;

public class StringCalculator {

    public int add(String inputString) {
        int result = 0;
        if (inputString.length() > 0) {
            result = Integer.parseInt(inputString);
        }
        return result;
    }
}
