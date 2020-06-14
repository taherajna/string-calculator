package com.incubyte.tdd;

import java.util.List;

public class UnsupportedNumberException extends Exception {

  public static final String NEGATIVES_NOT_ALLOWED = "Negatives not allowed: ";

  public UnsupportedNumberException(String message, List<Integer> unsupportedNumbers) {
    super(message + unsupportedNumbers);
  }
}
