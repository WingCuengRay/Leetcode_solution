package com.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanToIntegerTest {

    @Test
    public void romanToIntWithStack() {
        String str = "III";
        int result = RomanToInteger.romanToIntWithStack(str);
        assertEquals(3, result);

        str = "IV";
        result = RomanToInteger.romanToIntWithStack(str);
        assertEquals(4, result);

        str = "IX";
        result = RomanToInteger.romanToIntWithStack(str);
        assertEquals(9, result);

        str = "LVIII";
        result = RomanToInteger.romanToIntWithStack(str);
        assertEquals(58, result);

        str = "MCMXCIV";
        result = RomanToInteger.romanToIntWithStack(str);
        assertEquals(1994, result);
    }
}