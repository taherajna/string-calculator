package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorGetCalledCountTest {

  private StringCalculator stringCalculator;

  @Before
  public void setUp() {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void testGetCalledCount() throws UnsupportedNumberException {
    stringCalculator.add("");
    stringCalculator.add("");
    stringCalculator.add("");
    stringCalculator.add("");

    Assert.assertEquals(4, stringCalculator.getCalledCount());
  }
}
