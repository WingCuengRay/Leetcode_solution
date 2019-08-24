package com.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReverseIntegerTest {

    @Test
    public void reverseWithString() {
        int i = 123;
        int result = ReverseInteger.reverseWithString(i);
        assertEquals(321, result);

        i = -123;
        result = ReverseInteger.reverseWithString(i);
        assertEquals(-321, result);

        i = -2147483412;
        result = ReverseInteger.reverseWithString(i);
        assertEquals(-2143847412, result);

        i = 1563847412;
        result = ReverseInteger.reverseWithString(i);
        assertEquals(0, result);
    }


    @Test
    public void reverseWithMath() {
        int i = Integer.MIN_VALUE;
        int result = ReverseInteger.reverseWithMath(i);
        assertEquals(0, result);

        i = 123;
        result = ReverseInteger.reverseWithMath(i);
        assertEquals(321, result);

        i = -123;
        result = ReverseInteger.reverseWithMath(i);
        assertEquals(-321, result);

        i = -2147483412;
        result = ReverseInteger.reverseWithMath(i);
        assertEquals(-2143847412, result);

        i = 1563847412;
        result = ReverseInteger.reverseWithMath(i);
        assertEquals(0, result);
    }
}