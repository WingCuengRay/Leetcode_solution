package com.leetcode.category.substring;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters {
    /**
     * Improve the method below by replacing HashSet to an array which is used to detect a character repeat or not
     *
     */
    public int numKLenSubstrNoRepeats(String s, int k) {
        if (s.isEmpty() || k > s.length()) {
            return 0;
        }

        int[] set = new int[26];
        int start = 0;
        int end = 0;
        int cnt = 0;

        while (end < s.length()) {
            if (end - start >= k) {
                set[s.charAt(start) - 'a'] = 0;
                start++;
            }

            char ch = s.charAt(end);
            if (set[ch - 'a'] > 0) {
                int i;
                for (i = start; s.charAt(i) != ch && i < end; i++) {
                    set[s.charAt(i) - 'a'] = 0;
                }
                start = i + 1;
            } else if (end - start + 1 == k) {
                cnt++;
            }

            set[ch - 'a']++;
            end++;
        }

        return cnt;
    }

    /**
     * Using the idea of sliding window, similar to {@link LongestSubstringWithAtMostTwoDistinctCharacters}
     */
    public class FindKLengthSubstringsWithNoRepeatedCharactersWithHashMap {
        public int numKLenSubstrNoRepeats(String s, int k) {
            if (s.isEmpty() || k > s.length()) {
                return 0;
            }

            Set<Character> idxMap = new HashSet<>();
            int start = 0;
            int end = 0;
            int cnt = 0;

            while (end < s.length()) {
                if (end - start >= k) {
                    idxMap.remove(s.charAt(start));
                    start++;
                }

                char ch = s.charAt(end);
                if (idxMap.contains(ch)) {
                    int i;
                    for (i = start; s.charAt(i) != ch && i < end; i++) {
                        idxMap.remove(s.charAt(i));
                    }
                    start = i + 1;
                } else if (end - start + 1 == k) {
                    cnt++;
                }

                idxMap.add(ch);
                end++;
            }

            return cnt;
        }
    }
}
