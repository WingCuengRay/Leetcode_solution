package com.leetcode.medium;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivideTwoIntegersTest {

    @Test
    public void divide() {
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();

        assertEquals(3, divideTwoIntegers.divide(10, 3));
        assertEquals(-2, divideTwoIntegers.divide(7, -3));
        assertEquals(2147483647, divideTwoIntegers.divide(-2147483648, -1));
    }
}