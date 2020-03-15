package com.leetcode.medium;

import java.util.*;

public class GroupAnagrams {
    // N is the length of strs, and K is the average length of each string
    // Time: O(N*K)
    // Space: O(N*K)
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int []counts = new int[26];
        for(String str: strs) {
            Arrays.fill(counts, 0);
            for(int i=0; i<str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            String key = generateKey(counts);

            List<String> list = map.get(key);
            if(list != null) {
                list.add(str);
            } else  {
                list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }

        }

        return new ArrayList<>(map.values());
    }

    private String generateKey(int[] counts) {
        StringBuilder strBuilder = new StringBuilder();
        for(int count : counts) {
            strBuilder.append(count);
            strBuilder.append("#");
        }
        return strBuilder.toString();
    }

    // N is the length of strs, and K is the average length of each string
    // Time: O(N*KlogK)  (KlogK is the time to sort each string, which can be improved to O(N*27) by using counting sort, 26 is the number of lowercase letters)
    // Space: O(N*K)
    public List<List<String>> groupAnagrams_with_sort(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();

        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);

            List<String> list = maps.get(sortedStr);
            if(list != null) {
                list.add(str);
            } else {
                list = new ArrayList<>();
                list.add(str);
                maps.put(sortedStr, list);
            }
        }

        return new ArrayList<>(maps.values());
    }
}
