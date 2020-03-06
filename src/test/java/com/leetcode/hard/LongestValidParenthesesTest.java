package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {

    @Test
    public void longestValidParentheses() {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

        String s = "(()";
        assertEquals(2, longestValidParentheses.longestValidParentheses(s));

        s = ")()())";
        assertEquals(4, longestValidParentheses.longestValidParentheses(s));
    }
}