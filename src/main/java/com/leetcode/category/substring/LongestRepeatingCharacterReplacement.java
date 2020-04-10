package com.leetcode.category.substring;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int max = 0;

        while(start < s.length()) {
            final char ch = s.charAt(start);

            end = start + 1;
            int opCnt = k;
            int idxOfFirstNotEqual = -1;
            while(end < s.length() && opCnt >= 0) {
                if(s.charAt(end) != ch) {
                    if(opCnt == 0) {
                        break;
                    }

                    opCnt--;
                    idxOfFirstNotEqual = end;      // record the first idx of character that's different from the main character the  in the current slide window
                }
                end++;
            }

            if(idxOfFirstNotEqual == -1) {
                idxOfFirstNotEqual = end;
            }

            max = Math.max(max, end - start);
            start = idxOfFirstNotEqual;
        }

        return max;
    }
}
