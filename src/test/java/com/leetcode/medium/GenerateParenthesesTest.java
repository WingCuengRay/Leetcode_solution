package com.leetcode.medium;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class GenerateParenthesesTest {

    @Test
    public void generateParenthesis() {
        GenerateParentheses generateParentheses = new GenerateParentheses();

        List<String> actual = Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
        List<String> result = generateParentheses.generateParenthesis(4);

        actual.sort(String::compareTo);
        result.sort(String::compareTo);
        assertEquals(actual, result);
    }

    @Test
    public void generateParenthesis_NonRecursive() {
        GenerateParentheses generateParentheses = new GenerateParentheses();

        List<String> actual = Arrays.asList("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()");
        List<String> result = generateParentheses.generateParenthesis_NonRecursive(4);

        actual.sort(String::compareTo);
        result.sort(String::compareTo);
        assertEquals(actual, result);
    }
}