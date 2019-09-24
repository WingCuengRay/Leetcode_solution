package com.leetcode.hard;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularExpressionMatchingTest {
    

    @Test
    public void isMatch_2ndAttempt() {
        RegularExpressionMatching obj = new RegularExpressionMatching();

        String s = "aa";
        String p = "a";
        assertEquals(false, obj.isMatch_2ndAttempt(s, p));

        s = "aa";
        p = "a*";
        assertEquals(true, obj.isMatch_2ndAttempt(s, p));

        s = "ab";
        p = ".*";
        assertEquals(true, obj.isMatch_2ndAttempt(s, p));

        s = "aab";
        p = "c*a*b";
        assertEquals(true, obj.isMatch_2ndAttempt(s, p));

        s = "mississippi";
        p = "mis*is*p*.";
        assertEquals(false, obj.isMatch_2ndAttempt(s, p));

        s = "ab";
        p = ".*c";
        assertEquals(false, obj.isMatch_2ndAttempt(s, p));

        s = "aaa";
        p = "a*a";
        assertEquals(true, obj.isMatch_2ndAttempt(s, p));
    }

    @Test
    public void isMatch_1stAttempt() {
        RegularExpressionMatching obj = new RegularExpressionMatching();

        String s = "aa";
        String p = "a";
        assertEquals(false, obj.isMatch_1stAttempt(s, p));

        s = "aa";
        p = "a*";
        assertEquals(true, obj.isMatch_1stAttempt(s, p));

        s = "ab";
        p = ".*";
        assertEquals(true, obj.isMatch_1stAttempt(s, p));

        s = "sss";
        p = "s*s";
        assertEquals(true, obj.isMatch_1stAttempt(s, p));

        s = "aab";
        p = "c*a*b";
        assertEquals(true, obj.isMatch_1stAttempt(s, p));

        s = "mississippi";
        p = "mis*is*p*.";
        assertEquals(false, obj.isMatch_1stAttempt(s, p));
    }

    @Test
    public void isMatch_3ndAttemptWithDP() {
        RegularExpressionMatching obj = new RegularExpressionMatching();

        String s = "aa";
        String p = "a";
        assertEquals(false, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "aa";
        p = "a*";
        assertEquals(true, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "ab";
        p = ".*";
        assertEquals(true, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "aab";
        p = "c*a*b";
        assertEquals(true, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "mississippi";
        p = "mis*is*p*.";
        assertEquals(false, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "ab";
        p = ".*c";
        assertEquals(false, obj.isMatch_3ndAttemptWithDP(s, p));

        s = "aaa";
        p = "a*a";
        assertEquals(true, obj.isMatch_3ndAttemptWithDP(s, p));
    }
}