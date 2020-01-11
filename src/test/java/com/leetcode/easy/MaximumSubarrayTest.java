package com.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int max = maximumSubarray.maxSubArray_BruteForce(nums);
        assertEquals(6, max);
    }

    @Test
    public void maxSubArray_BruteForce() {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int max = maximumSubarray.maxSubArray(nums);
        assertEquals(6, max);
    }

    @Test
    public void maxSubArray_Divide_and_Conquer() {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};

        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int max = maximumSubarray.maxSubArray_Divide_and_Conquer(nums);
        assertEquals(6, max);
    }
}