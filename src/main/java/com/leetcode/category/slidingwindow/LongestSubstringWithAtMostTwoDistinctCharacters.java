package com.leetcode.category.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    /**
     * The idea of this algorithm is to store the latest index that a character occurred.
     * We only store (maybe update) two characters' index
     * because if there is a third character that is not in the store we need to remove the character with smallest index to maintain the condition (length of at most 2 characters).
     * Since we update the index of character if it occurs again (ex. "eeceba"), we wouldn't remove the wrong character.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.isEmpty()) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if(map.size() >= 2 && !map.containsKey(s.charAt(right))) {
                int charWithSmallestIdx = Collections.min(map.values());
                map.remove(s.charAt(charWithSmallestIdx));
                left = charWithSmallestIdx + 1;
            }

            map.put(s.charAt(right), right);
            right++;
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }

}
