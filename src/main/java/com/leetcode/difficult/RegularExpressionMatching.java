package com.leetcode.difficult;

/**
 * Created by Yongcong Lei on 8/27/2019
 */
public class RegularExpressionMatching {

    public boolean isMatch_3ndAttemptWithDP(String s, String p){
        // sub problems
        // s[i...N-1] and p[j...M-1] can be separated into 2 sub-problems in 2 situation
        // 1. no following '*'
        //      a. if s[i] matches p[j]
        //      b. if s[i...N-1] matches p[j...M-1]
        // 2. with following '*'
        //      a. if s[i] matches p[j], and s[i+1...N-1] matches p[j..M-1] (dp[i+1][j])
        //      b. s[i...N-1] matches p[i+2...M-1] (dp[i][j+2])
        // base case: dp[N][M] = true -- s[N..] == p[M...] == ""
        //            dp[0...n-1][M] = false;

        boolean dp[][] = new boolean[s.length()+1][p.length()+1];
        dp[s.length()][p.length()] = true;
        for(int i=0; i<=s.length()-1; i++)
            dp[i][p.length()] = false;

        for(int i=s.length(); i>=0; i--){
            for(int j=p.length()-1; j>=0; j--){
                boolean firstMatch = i<s.length() && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
                if(j+1==p.length() || p.charAt(j+1)!='*')
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                else if(j+1<p.length() && p.charAt(j+1)=='*'){
                    if(firstMatch)
                        dp[i][j] =  dp[i+1][j] || dp[i][j+2];
                    else
                        dp[i][j] = dp[i][j+2];
                }
            }
        }

        return dp[0][0];
    }

    public boolean isMatch_2ndAttempt(String s, String p){
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        boolean firstMatch = !s.isEmpty() && (p.charAt(0)=='.' || s.charAt(0) == p.charAt(0));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            /**
            if(firstMatch)
                return isMatch_2ndAttempt(s, p.substring(2)) || isMatch_2ndAttempt(s.substring(1), p);       // ex: "ss" and "s*"
            else
                return isMatch_2ndAttempt(s, p.substring(2));       // ex: "ss" and "a*ss"
             **/
            // The code above can be refined to
            // There are two situations if '*' occurs. ex. "aaa" and "a*a"
            // 1. 'a*' can be seen as one ore more characters of 'a', which should only be used if first character of both string matches.
            // 2. 'a*' can be seen as empty string, which should be used no matter firstMatch is true or false.
            return isMatch_2ndAttempt(s, p.substring(2)) || (firstMatch && isMatch_2ndAttempt(s.substring(1), p));
        } else {
            return firstMatch && isMatch_2ndAttempt(s.substring(1), p.substring(1));
        }
    }

    /**
     * Third Attempt: Succeed after adding base case and fixing situation about "aa" and "a*"
     * First Attempt: Failure
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_1stAttempt(String s, String p) {
        int s_len = s.length();
        int p_len = p.length();
        byte[] str = s.getBytes();
        byte[] pattern = p.getBytes();

        boolean [][] arr = new boolean[s_len+1][p_len+1];
        arr[0][0] = true;                           // base case
        for(int j=1; j<=p_len; j++){
            if(pattern[j-1] == '*')
                arr[0][j] = arr[0][j-2];            // base case
        }

        for(int i=1; i<=s_len; i++){
            for(int j=1; j<=p_len; j++){
                byte chars = str[i-1];
                byte charp = pattern[j-1];
                if(charp != '*'){
                    if(charp=='.' || chars==charp)
                        arr[i][j] = arr[i-1][j-1];
                    else
                        arr[i][j] = false;
//                    arr[i][j] = arr[i-1][j-1] && (charp=='.' || chars==charp);
                } else {
                    // if pattern[j-1] == '*', there must be j-1>=1 cause '*' can't be the first character.
                    if(pattern[j-2]=='.' || chars == pattern[j-2])
                        arr[i][j] = arr[i-1][j] || arr[i][j-2];
                    else
                        arr[i][j] = arr[i][j-2];
//                    arr[i][j] = arr[i][j-1] ||
//                        ((pattern[j-2]=='.' || chars == pattern[j-2]) && arr[i-1][j]);
                }
            }
        }

        return arr[s_len][p_len];
    }
}
