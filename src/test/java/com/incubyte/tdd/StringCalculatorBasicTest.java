package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorBasicTest {

  private StringCalculator stringCalculator;

  @Before
  public void setUp() {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void testClassExists() {
    Assert.assertNotNull(stringCalculator);
  }

  @Test
  public void testAddForEmptyString() throws UnsupportedNumberException {
    Assert.assertEquals(0, stringCalculator.add(""));
  }

  @Test
  public void testAddForSingleNumber() throws UnsupportedNumberException {
    Assert.assertEquals(1, stringCalculator.add("1"));
    Assert.assertEquals(10, stringCalculator.add("10"));
  }

  @Test
  public void testAddForTwoNumbers() throws UnsupportedNumberException {
    Assert.assertEquals(3, stringCalculator.add("1,2"));
    Assert.assertEquals(12 + 34, stringCalculator.add("12,34"));
  }

  @Test
  public void testAddFor_AnyAmountOfCommaSeparatedNumbers() throws UnsupportedNumberException {
    Assert.assertEquals(1 + 2 + 3 + 4 + 5, stringCalculator.add("1,2,3,4,5"));
    Assert.assertEquals(12 + 34 + 72 + 88, stringCalculator.add("12,34,72,88"));
  }
}
