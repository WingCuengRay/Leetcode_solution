package com.leetcode.hard;

import java.util.stream.IntStream;

public class LongestValidParentheses {
    /**
     *          0   if i == 0
     * dp[i] =  0   if s[i] == '('
     *          dp[i-2] + 2                         if s[i] == ')' and s[i-1] == '('
     *          dp[i-1] + 2 + dp[i - dp[i-1] - 2]   if s[i] == ')' and s[i - dp[i-1] -1] == '('
     *          0                                   otherwise
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        // let dp[i] be the lenght of longest valid substring that end with s[i]
        int dp[] = new int[s.length()];
        int maxLen = 0;

        dp[0] = 0;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                dp[i] = 0;
            } else if(s.charAt(i) == ')' && s.charAt(i-1) == '(') {
                if(i - 2 >= 0)
                    dp[i] = dp[i-2] + 2;
                else {
                    dp[i] = 2;
                }
            } else {
                if(i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                    final int lenOfValidSubstringBefore = (i - dp[i-1] - 2 >= 0) ? dp[i - dp[i-1] - 2] : 0;
                    dp[i] = dp[i-1] + 2 + lenOfValidSubstringBefore;
                } else {
                    dp[i] = 0;
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
