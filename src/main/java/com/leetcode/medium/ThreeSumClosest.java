package com.leetcode.medium;

import java.util.Arrays;

/**
 * Created by Yongcong Lei on 9/17/2019
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // No hashing, only two pointers
        Arrays.sort(nums);

        int gap = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int left = i+1;
            int right = nums.length-1;

            while(left < right){
                if(Math.abs(gap) > Math.abs(nums[i] + nums[left] + nums[right] - target))
                    gap = nums[i] + nums[left] + nums[right] - target;

                if(nums[i] + nums[left] + nums[right] < target) {
                    left++;
                }
                else if(nums[i] + nums[left] + nums[right] > target)
                    right--;
                else
                    return target;
            }
        }

        return target + gap;
    }
}
