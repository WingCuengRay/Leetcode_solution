package com.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

    // An important thing to be noticed in that the first missing positive number must be
    // in range [1, nums.length + 1] since there are at most nums.length positive integers in nums.
    public int firstMissingPositive(int[] nums) {
        // partition the array into two parts. The first part are all positive numbers;
        final int positiveLen = separate(nums);
        for(int i=0; i<positiveLen; i++) {
            final int currAbs = Math.abs(nums[i]);
            if(currAbs <= positiveLen) {
                nums[currAbs - 1] = -1 * Math.abs(nums[currAbs - 1]);
            }
        }

        for(int i=0; i<positiveLen; i++) {
            if(nums[i] > 0) {
                return i + 1;
            }
        }

        return positiveLen + 1;
    }

    // partition the array into two parts. The first part are all positive numbers;
    private int separate(int[] nums) {
        int positiveLen = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                swap(nums, i, positiveLen);
                positiveLen++;
            }
        }

        return positiveLen;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    // Time Complexity: O(n)
    // Space Complexity: O(n)
    // need to reduce space complexity to O(1)
    public int firstMissingPositive_O_N(int[] nums) {
        int min = Integer.MAX_VALUE;
        Set<Integer> found = buildSet(nums);

        for(int i=1; i<=nums.length; i++) {
            if(!found.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;
    }


    Set<Integer> buildSet(int[] nums) {
        Set<Integer> found = new HashSet<>(nums.length + 1);

        for(int num: nums) {
            found.add(num);
        }

        return found;
    }
}
