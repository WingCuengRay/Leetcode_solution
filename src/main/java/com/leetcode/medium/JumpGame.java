package com.leetcode.medium;

public class JumpGame {
    // Greedy Algorithm
    // Time: O(N), N is the length of array
    // Space: O(1)
    public boolean canJump_Greedy(int[] nums) {
        if(nums.length == 0)
            return false;

        // we only need to keep the left-most index which can jump to the last index
        // if the current jump is greater or equal than the left-most index, the current index is also valid
        int leftMostIndex = nums.length - 1;
        for(int i=nums.length-2; i>=0; i--) { ;
            if(i+nums[i] >= leftMostIndex) {
                leftMostIndex = i;
            }
        }

        return leftMostIndex == 0;
    }


    // Dynamic Programming alogrithm
    // Time: O(N^2), N is the length of array
    // Space: O(N)
    public boolean canJump_DP(int[] nums) {
        if(nums.length == 0)
            return false;

        boolean []c = new boolean[nums.length];
        c[nums.length - 1] = true;

        for(int i=nums.length-2; i>=0; i--) {
            c[i] = false;
            for(int j=nums[i]; j>=1; j--) {
                if(i + j >= nums.length - 1) {
                    c[i] = true;
                } else {
                    c[i] = c[i+j];
                }

                if(c[i])
                    break;
            }
        }

        return c[0];
    }
}
