package com.leetcode.difficult;

/**
 * Created by Yongcong Lei on 8/30/2019
 */
public class WildcardMatching {

    /**
     * First approach: Recursion
     *
     * Time complexity: O(2^(m+n))
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_Recursion(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }

        if(p.charAt(0) == '*')
            return isMatch_Recursion(s, p.substring(1)) || (!s.isEmpty() && isMatch_Recursion(s.substring(1), p));
        else {
            boolean firstMatch = !s.isEmpty() &&
                (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0));
            return firstMatch && isMatch_Recursion(s.substring(1), p.substring(1));
        }
    }

    /**
     * Second approach: Dynamic programming for Wildcard Matching
     *
     * Time complexity: O(MN)
     */
    public boolean isMatch_DP(String s, String p){
        boolean dp[][] = new boolean[s.length()+1][p.length()+1];

        for(int i=s.length(); i>=0; i--){
            for(int j=p.length(); j>=0; j--){
                if(i == s.length() && j == p.length())
                    dp[i][j] = true;
                else if(i == s.length() && j < p.length())
                    dp[i][j] = p.charAt(j) == '*'? dp[i][j+1] : false;
                else if(i < s.length() && j == p.length())
                    dp[i][j] = false;
                else {
                    // i < s.length && j < p.length()
                    boolean firstMatch = p.charAt(j)=='?' || s.charAt(i)==p.charAt(j);
                    if(p.charAt(j) == '*')
                        dp[i][j] = dp[i][j+1] || dp[i+1][j];
                    else
                        dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }

    /**
     * Inspired by fastest solution in Leetcode
     *
     * Time Complexity: wrose case - O(MN), but the case happens infrequently.
     */
    public boolean isMatch_Tricky(String s, String p){
        int i = 0;
        int j = 0;
        int nextI = -1;              // the index of char to track back if something doesn't match
        int nextJ = -1;              // the index of char after a '*', for trace-back if something doesn't match

        while(i < s.length()){
            if(j < p.length() && (p.charAt(j)=='?' || s.charAt(i) == p.charAt(j)) ){
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*'){
                nextI = i+1;
                nextJ = ++j;
            } else if(nextI != -1) {            // a mismatch happens, then trace back if a '*' happens before.
                // trace back
                i = nextI++;
                j = nextJ;              // let j trace back to be the next character of '*'
            } else
                return false;           // No '*' occurs before a mismatch happens
        }

        while (j < p.length() && p.charAt(j) == '*')
            j++;                        // skip tailing '*'

        return j == p.length();         // return true if everything in pattern has been matched, false otherwise.
    }
}
