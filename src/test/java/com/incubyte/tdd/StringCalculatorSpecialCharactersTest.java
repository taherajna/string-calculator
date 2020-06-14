package com.incubyte.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorSpecialCharactersTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void testAddFor_NewLineCharacters() {
        Assert.assertEquals(3, stringCalculator.add("1\n2"));
    }
}
