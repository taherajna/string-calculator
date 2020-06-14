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
}
