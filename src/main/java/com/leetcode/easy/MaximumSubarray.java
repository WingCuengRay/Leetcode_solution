package com.leetcode.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        int tmp = 0;
        for(int i=0; i<nums.length; i++) {
            if(tmp < 0) {
                tmp = 0;
            }

            tmp += nums[i];
            if(tmp > max)
                max = tmp;
        }

        return max;
    }

    public int maxSubArray_Divide_and_Conquer(int[] nums){
        AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);

        maxSubArray_Divide_and_Conquer(nums, nums.length-1, max);

        return max.get();
    }

    private int maxSubArray_Divide_and_Conquer(int[] nums, int n, AtomicInteger max){
        if(n == 0) {
            max.set(nums[0]);
            return nums[0];
        }

        int tmp = maxSubArray_Divide_and_Conquer(nums, n-1, max);
        int val = tmp > 0?  tmp + nums[n] : nums[n];
        max.set(Math.max(max.get(),  val));

        return val;
    }

    public int maxSubArray_BruteForce(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            int sum = nums[i];
            if(sum > max)
                max = sum;

            int j;
            for(j=i+1; j<nums.length; j++) {
                sum += nums[j];

                if(sum > max)
                    max = sum;
            }
        }

        return max;
    }
}
