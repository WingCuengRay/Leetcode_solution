package com.leetcode.category.sum;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    /**
     * Improve the method below with HashMap. Use HashMap to lookup the index of a value.
     *
     * The idea of this problem is abut Prefix Sum. The prefix sum, cumulative sum, inclusive scan, or simply scan of a sequence of numbers.
     * Suppose we have two prefix sum p[i] and p[j] (j > i). If there is a subarray sum equals to k, there must be j and i (n > j > i >= 0) such that p[j] - p[i] = k.
     * After the calculate the prefix sum of the array, the problem can be reduced to the Two Sum {@linktourl  https://leetcode.com/problems/two-sum/} problem, which can be solved efficiently with HashMap
     *
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public class MaximumSizeSubarraySumEqualsK_WithHashMap {
        public int maxSubArrayLen(int[] nums, int k) {
            Map<Integer, Integer> preSumMap = new HashMap<>();

            int maxLen = 0;
            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                sum += nums[i];

                int rest = sum - k;
                if(rest == 0) {
                    maxLen = Math.max(maxLen, i+1);
                } else {
                    Integer firstIdx = preSumMap.get(rest);
                    if(firstIdx != null) {
                        maxLen = Math.max(maxLen, i - firstIdx);
                    }
                }

                // keep the one that shows up first since we need the maximum size of subarray
                if(!preSumMap.containsKey(sum)) {
                    preSumMap.put(sum, i);
                }
            }

            return maxLen;
        }
    }

    /**
     * Use array to store the prefix sum
     *
     * Time Complexity: O(n^2)
     * Further improvement: use HashMap instead of array to achieve O(1) search time
     */
    public class MaximumSizeSubarraySumEqualsK_WithArray {
        public int maxSubArrayLen(int[] nums, int k) {
            int []preSum = new int[nums.length];

            int sum = 0;
            for(int i=0; i<nums.length; i++) {
                sum += nums[i];
                preSum[i] = sum;
            }

            int maxLen = 0;
            for(int i=0; i<preSum.length; i++) {
                int rest = preSum[i] - k;

                if(rest == 0) {
                    maxLen = Math.max(maxLen, i+1);
                } else {
                    int firstIdx = findValue(preSum, rest, i);

                    if(firstIdx != -1) {
                        maxLen = Math.max(maxLen, i - firstIdx);
                    }
                }
            }

            return maxLen;
        }

        int findValue(int[] preSum, int val, int end) {
            for(int i=0; i<end; i++) {
                if(preSum[i] == val)
                    return i;
            }

            return -1;
        }
    }
}
