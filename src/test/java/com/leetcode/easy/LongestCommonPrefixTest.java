package com.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonPrefixTest {

    @Test
    public void longestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String []strs = {"flower","flow","flight"};
        String result = longestCommonPrefix.longestCommonPrefix(strs);
        assertEquals("fl", result);

        String []strs_2 = {"dog","racecar","car"};
        String result_2 = longestCommonPrefix.longestCommonPrefix(strs_2);
        assertEquals("", result_2);
    }

    @Test
    public void longestCommonPrefix_2nd() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String []strs = {"flower","flow","flight"};
        String result = longestCommonPrefix.longestCommonPrefix_2nd(strs);
        assertEquals("fl", result);

        String []strs_2 = {"dog","racecar","car"};
        String result_2 = longestCommonPrefix.longestCommonPrefix_2nd(strs_2);
        assertEquals("", result_2);
    }
}