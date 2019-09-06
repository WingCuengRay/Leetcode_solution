package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestPalindromicSubstringTest {
    @Test
    public void longestPalindrome(){
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        assertEquals("bab", longestPalindromicSubstring.longestPalindrome("babad"));
        assertEquals("bb", longestPalindromicSubstring.longestPalindrome("cbbd"));
        assertEquals("tattarrattat", longestPalindromicSubstring.longestPalindrome("tattarrattat"));
    }


    @Test
    public void longestPalindrome_DP() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        assertEquals("bab", longestPalindromicSubstring.longestPalindrome_DP("babad"));
        assertEquals("bb", longestPalindromicSubstring.longestPalindrome_DP("cbbd"));
        assertEquals("tattarrattat", longestPalindromicSubstring.longestPalindrome_DP("tattarrattat"));
    }

    @Test
    public void longestPalindrome_DP_optimal() {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();

        assertEquals("bab", longestPalindromicSubstring.longestPalindrome_DP_optimal("babad"));
        assertEquals("bb", longestPalindromicSubstring.longestPalindrome_DP_optimal("cbbd"));
        assertEquals("tattarrattat", longestPalindromicSubstring.longestPalindrome_DP_optimal("tattarrattat"));
    }
}