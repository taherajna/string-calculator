package com.incubyte.tdd;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

  private int calledCount = 0;

  public int add(String inputString) throws UnsupportedNumberException {
    calledCount++;
    int result = 0;
    if (inputString.length() > 0) {
      List<Delimiter> delimiter = resolveDelimiter(inputString);
      String[] split;
      if (delimiter.isEmpty()) {
        split = inputString.split(Delimiter.getDefaultDelimiter().getDelimiter());
      } else {
        split = getSplittedString(inputString, delimiter);
      }
      List<Integer> unsupportedNumbers = new ArrayList<Integer>();
      for (String stringNumber : split) {
        int intNumber = Integer.parseInt(stringNumber);
        if (intNumber < 0) {
          unsupportedNumbers.add(intNumber);
        } else if (intNumber <= 1000) {
          result += intNumber;
        }
      }
      if (unsupportedNumbers.size() > 0) {
        throw new UnsupportedNumberException(
                UnsupportedNumberException.NEGATIVES_NOT_ALLOWED, unsupportedNumbers);
      }
    }
    return result;
  }

  private String[] getSplittedString(String inputString, List<Delimiter> delimiters) {
    StringBuilder delimiterBuilder = new StringBuilder();
    for (Delimiter delimiter : delimiters) {
      delimiterBuilder.append(delimiter.getDelimiter());
    }
    return inputString.split("\n")[1].split(delimiterBuilder.toString());
  }

  private List<Delimiter> resolveDelimiter(String inputString) {
    List<Delimiter> delimiter = new ArrayList<Delimiter>();
    if (inputString.length() > 4 && inputString.startsWith("//")) {
      delimiter.add(
              Delimiter.getDelimiterFor(
                      inputString.split("\n")[0].substring(2).replace("[", "").replaceAll("]", "")));
    }
    return delimiter;
  }

  public int getCalledCount() {
    return calledCount;
  }
}
