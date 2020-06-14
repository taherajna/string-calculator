package com.incubyte.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

  private int calledCount = 0;

  public int add(String inputString) throws UnsupportedNumberException {
    calledCount++;
    int result = 0;
    if (inputString.length() > 0) {
      List<Delimiter> delimiters = resolveDelimiters(inputString);
      String[] split = getSplittedString(inputString, delimiters);
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
    String[] splitStringsArray;
    List<String> splitStrings = new ArrayList<String>();
    if (delimiters.isEmpty()) {
      splitStringsArray = inputString.split(Delimiter.getDefaultDelimiter().getDelimiter());
    } else {
      for (Delimiter delimiter : delimiters) {
        if (splitStrings.isEmpty()) {
          splitStrings.addAll(
                  Arrays.asList(inputString.split("\n")[1].split(delimiter.getDelimiter())));
        } else {
          for (int i = 0; i < splitStrings.size(); i++) {
            String[] subSplit = splitStrings.get(i).split(delimiter.getDelimiter());
            if (subSplit.length > 1) {
              splitStrings.remove(i);
              splitStrings.addAll(Arrays.asList(subSplit));
            }
          }
        }
      }
      splitStringsArray = splitStrings.toArray(new String[0]);
    }
    return splitStringsArray;
  }

  private List<Delimiter> resolveDelimiters(String inputString) {
    List<Delimiter> delimiters = new ArrayList<Delimiter>();
    if (inputString.length() > 4 && inputString.startsWith("//")) {
      String[] delimitersSplit = inputString.split("\n")[0].substring(2).split("\\]\\[");
      for (String delimiterString : delimitersSplit) {
        delimiters.add(
                Delimiter.getDelimiterFor(delimiterString.replace("[", "").replaceAll("]", "")));
      }
    }
    return delimiters;
  }

  public int getCalledCount() {
    return calledCount;
  }
}
