package com.incubyte.tdd;

public class StringCalculator {

    public int add(String inputString) throws UnsupportedNumberException {
        int result = 0;
        if (inputString.length() > 0) {
            Delimiter delimiter = resolveDelimiter(inputString);
            String[] split;
            if (delimiter.isDefault()) {
                split = inputString.split(delimiter.getDelimiter());
            } else {
                split = inputString.substring(4).split(delimiter.getDelimiter());
            }
            for (String stringNumber : split) {
                int intNumber = Integer.parseInt(stringNumber);
                if (intNumber < 0) {
                    throw new UnsupportedNumberException(UnsupportedNumberException.NEGATIVES_NOT_ALLOWED, intNumber);
                }
                result += intNumber;
            }
        }
        return result;
    }

    private Delimiter resolveDelimiter(String inputString) {
        Delimiter delimiter;
        if (inputString.length() > 4 && inputString.startsWith("//")) {
            delimiter = Delimiter.getDelimiterFor(inputString.substring(2, 3));
        } else {
            delimiter = Delimiter.getDefaultDelimiter();
        }
        return delimiter;
    }
}
