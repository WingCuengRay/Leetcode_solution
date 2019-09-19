package com.leetcode.medium;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class LetterCombinationTest {

    @Test
    public void letterCombinations() {
        LetterCombination letterCombination = new LetterCombination();
        List<String> result = letterCombination.letterCombinations("23");

        assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), result);
    }
}