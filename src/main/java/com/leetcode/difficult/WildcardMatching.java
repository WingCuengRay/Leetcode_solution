package com.leetcode.difficult;

/**
 * Created by Yongcong Lei on 8/30/2019
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }

        if(p.charAt(0) == '*')
            return isMatch(s, p.substring(1)) || (!s.isEmpty() && isMatch(s.substring(1), p));
        else {
            boolean firstMatch = !s.isEmpty() &&
                (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0));
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

//
//        boolean firstMatch = !s.isEmpty() &&
//            (p.charAt(0) == '?' || p.charAt(0) == '*' || s.charAt(0) == p.charAt(0));
//        if(firstMatch) {
//            if (p.charAt(0) == '*') {
//                return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
//            } else
//                return isMatch(s.substring(1), p.substring(1));
//        } else {
//            if(firstMatch || p.charAt(0)=='*')
//                return isMatch(s, p.substring(1));
//            else
//                return false;
//        }
    }

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

//        for(int i=0; i<=s.length(); i++)
//            dp[i][p.length()] = false;
//        boolean pEmpty = p.replace("*", "").isEmpty();
//        for(int j=0; j<=p.length(); j++)
//            dp[s.length()][j] = pEmpty;
//        dp[s.length()][p.length()] = true;
//
//        for(int i=s.length(); i>=0; i--){
//            for(int j=p.length()-1; j>=0; j--){
//                boolean firstMatch = i < s.length() && (p.charAt(j) == '?' || p.charAt(j) == '*' || p.charAt(j) == s.charAt(i));
//                if(firstMatch){
//                    if(p.charAt(j) != '*')
//                        dp[i][j] = dp[i+1][j+1];
//                    else {
//                        dp[i][j] = dp[i][j+1] || dp[i+1][j] || dp[i+1][j+1];
//                    }
//                } else {
//                    if(p.charAt(j) != '*')
//                        dp[i][j] = false;
//                    else
//                        dp[i][j] = dp[i][j+1];
//                }
//            }
//        }

//        return dp[0][0];
    }
}
