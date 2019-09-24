package com.leetcode.hard;

import static org.junit.Assert.*;

import org.junit.Test;

public class WildcardMatchingTest {

    @Test
    public void isMatch() {
        WildcardMatching wildcardMatching = new WildcardMatching();

        boolean result = wildcardMatching.isMatch_Recursion("acdcb", "a*c?b");
        assertFalse(result);


        result = wildcardMatching.isMatch_Recursion("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
            "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");
        assertTrue(result);

        // the application will get stuck here because the time complexity for recursive algorithm is too high
        // and it take lots of time until it finishes.
        result = wildcardMatching.isMatch_Recursion("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
            "a*******b");
        assertFalse(result);
    }

    @Test
    public void isMatch_DP() {
        WildcardMatching wildcardMatching = new WildcardMatching();

        boolean result = wildcardMatching.isMatch_DP("acdcb", "a*c?b");
        assertFalse(result);


        result = wildcardMatching.isMatch_DP("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
            "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");
        assertTrue(result);

        result = wildcardMatching.isMatch_DP("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
            "a*******b");
        assertFalse(result);
    }

    @Test
    public void isMatch_Tricky() {
        WildcardMatching wildcardMatching = new WildcardMatching();

        boolean result = wildcardMatching.isMatch_Tricky("acdcb", "a*c?b");
        assertFalse(result);


        result = wildcardMatching.isMatch_Tricky("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
            "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");
        assertTrue(result);

        result = wildcardMatching.isMatch_Tricky("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba",
            "a*******b");
        assertFalse(result);
    }

}