package com.leetcode.medium;

/**
 * Created by Yongcong Lei on 9/5/2019
 */
public class LongestPalindromicSubstring {

    /**
     * Third approach: DP with linear time complexity
     *
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public String longestPalindrome_DP_optimal(String s){
        boolean last[] = new boolean[s.length()];
        boolean lastLast[] = new boolean[s.length()];
        boolean cur[] = new boolean[s.length()];

        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int k=0; k<s.length(); k++){
            for(int i=0; i+k<s.length(); i++){
                int j = i+k;
                if(i == j)
                    cur[j] = true;
                else if(j == i+1 && s.charAt(i) == s.charAt(j))
                    cur[j] = true;
                else if(j == i+1 && s.charAt(i) != s.charAt(j))
                    cur[j] = false;
                else
                    cur[j] = lastLast[j-1] && s.charAt(i) == s.charAt(j);

                if(cur[j] == true && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    start = i;
                    end = j;
                }
            }

            boolean tmp[] = last;
            last = lastLast;
            lastLast = tmp;

            tmp = last;
            last = cur;
            cur = tmp;
        }

        if(maxLen == 0)
            return "";
        else
            return s.substring(start, end+1);
    }

    /**
     * Second approach: Dynamic Programming
     *
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public String longestPalindrome_DP(String s){
        boolean dp[][] = new boolean[s.length()][s.length()];

        int maxLen = 0;
        int start = 0;
        int end = 0;
        for(int k=0; k<s.length(); k++){
            for(int i=0; i+k<s.length(); i++) {
                int j = i + k;

                if(i == j)
                    dp[i][j] = true;
                else if(j == i+1){
                    if(s.charAt(i) == s.charAt(j))
                        dp[i][j] = true;
                    else
                        dp[i][j] = false;
                }
                else
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);

                if(dp[i][j] == true && j-i+1 > maxLen){
                    maxLen = j-i+1;
                    start = i;
                    end = j;
                }
            }
        }

        if(maxLen == 0)
            return "";
        else
            return s.substring(start, end+1);
     }

    /**
     * First Approach: Expand center
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public String longestPalindrome(String s) {
        String result = "";
        int longest = 0;

        for(int i=0; i<s.length(); i++){
            String substr1 = longestPalindrome(s, i, i);
            String substr2 = longestPalindrome(s, i, i+1);

            if(substr1.length() > longest) {
                longest = substr1.length() ;
                result = substr1;
            }
            if(substr2.length() > longest) {
                longest = substr2.length();
                result = substr2;
            }
        }

        return result;
    }

    private String longestPalindrome(String s, int left, int right) {
        while(left>=0 && right<s.length()){
            if(s.charAt(left) != s.charAt(right))
                break;
            left--;
            right++;
        }

        if(right == left+1)
            return "";

        return s.substring(left+1, right);
    }


//    Wrong submission
//    public String longestPalindrome(String s) {
//        int longest = 0;
//        int idx = -1;
//
//        for(int i=0; i<s.length(); i++){
//            int offset = 0;
//            while(i-offset>=0 && i+offset < s.length()){
//                if(s.charAt(i-offset) != s.charAt(i+offset))
//                    break;
//                offset++;
//            }
//
//            int numOfEach = offset - 1;
//            int left = i - numOfEach;
//            int right = i + numOfEach;
//
//            int length = numOfEach*2 + 1;
//            if(right+1 < s.length() && isPalindrome(s.substring(left, right+1+1)))
//                length++;
//
//            if(length > longest){
//                longest = length;
//                idx = i;
//            }
//        }
//
//        if(longest == 0)
//            return "";
//
//        int numOfEach = (longest-1) /2;
//        int left = idx - numOfEach;
//        int right = idx + numOfEach + (longest%2==0?1:0);
//        return s.substring(left, right+1);
//    }


//    private boolean isPalindrome(String substring) {
//        int i=0;
//        int j=substring.length()-1;
//
//        while(i < j){
//            if(substring.charAt(i) != substring.charAt(j))
//                return false;
//            i++;
//            j--;
//        }
//
//        return true;
//    }
}
