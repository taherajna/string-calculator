package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorCustomDelimiterTest {
  private StringCalculator stringCalculator;

  @Before
  public void setUp() {
    stringCalculator = new StringCalculator();
  }

  @Test
  public void testForDelimiterProvidedToAdd() throws UnsupportedNumberException {
    Assert.assertEquals(3, stringCalculator.add("//;\n1;2"));
    Assert.assertEquals(3, stringCalculator.add("//,\n1,2"));
    Assert.assertEquals(24 + 72, stringCalculator.add("///\n24/72"));
  }

  @Test
  public void testFor_CustomDelimiterOfAnySize() throws UnsupportedNumberException {
    Assert.assertEquals(3, stringCalculator.add("//[**]\n1**2"));
    Assert.assertEquals(24 + 72, stringCalculator.add("//[***]\n24***72"));
  }

  @Test
  public void testFor_CustomMutipleDelimiters() throws UnsupportedNumberException {
    Assert.assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
  }

  @Test
  public void testFor_CustomMutipleDelimiters_variedLengths() throws UnsupportedNumberException {
    Assert.assertEquals(6, stringCalculator.add("//[**][%%]\n1**2%%3"));
    Assert.assertEquals(10, stringCalculator.add("//[**][%%][/]\n1**2%%3/4"));
  }
}
