package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorNegativeTesting {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test(expected = UnsupportedNumberException.class)
    public void testAddForNegativeNumber() throws UnsupportedNumberException {
        stringCalculator.add("-1");
    }

    @Test(expected = UnsupportedNumberException.class)
    public void testAddForNegativeAndPositiveNumbers_expectException() throws UnsupportedNumberException {
        stringCalculator.add("4,-1");
    }

    @Test
    public void testAddForNegativeNumber_assertErrorMessage() {
        try {
            stringCalculator.add("4,-1");
        } catch (UnsupportedNumberException e) {
            Assert.assertEquals("Negatives not allowed: " + -1, e.getMessage());
        }
    }
}
