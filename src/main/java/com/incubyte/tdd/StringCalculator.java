package com.incubyte.tdd;

public class StringCalculator {

    public int add(String inputString) {
        int result = 0;
        String[] split = inputString.split("[\n,]");
        for (String number : split) {
            if (number.length() > 0) {
                result += Integer.parseInt(number);
            }
        }
        return result;
    }
}
