package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

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
    public void testAddForEmptyString() {
        Assert.assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAddForSingleDigit() {
        Assert.assertEquals(1, stringCalculator.add("1"));
        Assert.assertEquals(10, stringCalculator.add("10"));
    }

}
