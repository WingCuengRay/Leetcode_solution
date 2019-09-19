package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringToIntegerTest {

    @Test
    public void myAtoi() {
        StringToInteger stringToInteger = new StringToInteger();

        int result = stringToInteger.myAtoi("   -42");
        assertEquals(-42, result);

        result = stringToInteger.myAtoi("4193 with words");
        assertEquals(4193, result);

        result = stringToInteger.myAtoi("words and 987");
        assertEquals(0, result);

        result = stringToInteger.myAtoi("-91283472332");
        assertEquals(-2147483648, result);
    }
}