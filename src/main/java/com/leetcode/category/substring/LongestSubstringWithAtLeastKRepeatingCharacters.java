package com.leetcode.category.substring;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    /**
     * Use divide and conquer to solve the problem. Preferred solution: more elegant and easier to remember
     *
     * First find the index of character that occurs times 0 < occ(ch) < k. If there is no such character in String, it means all the characters in this String occurs at least k times.
     * If there is such a character, partition the the string into two part. Then recursively do the same operation on the two parts and get the maximum length from the result.
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(N)
     */
    public class LongestSubstringWithAtLeastKRepeatingCharacters_DivideAndConquer {
        public int longestSubstring(String s, int k) {
            if(s.isEmpty() || k > s.length()) {
                return 0;
            }

            int pivot = partition(s, k);
            if(pivot == -1) {
                return s.length();
            }

            return Math.max(longestSubstring(s.substring(0, pivot), k), longestSubstring(s.substring(pivot + 1), k));
        }

        private int partition(String s, int k) {
            int map[] = new int[26];
            for(char ch : s.toCharArray()) {
                map[ch - 'a']++;
            }

            for(int i=0; i < map.length; i++) {
                if(map[i] > 0 && map[i] < k) {
                    return s.indexOf(i + 'a');
                }
            }

            return -1;
        }

    }



    /**
     * Still Divide and Conquer, but with optimization.
     *
     * The optimization is on the recursive function. This one only does one recursive call while the original method does two. However, the original one is more elegant.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public class LongestSubstringWithAtLeastKRepeatingCharacters_DivideAndConquer_Optimization {
        public int longestSubstring(String s, int k) {
            if(s.isEmpty() || k > s.length()) {
                return 0;
            }

            int map[] = new int[26];
            for(char ch : s.toCharArray()) {
                map[ch - 'a']++;
            }

            boolean isWholeValid = true;
            for(int cnt : map) {
                if(cnt > 0 && cnt < k) {
                    isWholeValid = false;
                }
            }

            if(isWholeValid) {
                return s.length();
            }

            int start = 0;
            int curr = 0;
            int maxLen = 0;
            while(curr < s.length()) {
                final char ch = s.charAt(curr);
                if(map[ch - 'a'] > 0 && map[ch - 'a'] < k) {
//                  maxLen = Math.max(maxLen, curr - start);                                        // we can't ensure the whole s.substring(start, curr) is a valid substring after split (in range [start, curr])
                    maxLen = Math.max(maxLen, longestSubstring(s.substring(start, curr), k));       // so we need to recursively check it
                    start = curr+1;
                }

                curr++;
            }

            maxLen = Math.max(maxLen, longestSubstring(s.substring(start), k));

            return maxLen;
        }
    }


}
