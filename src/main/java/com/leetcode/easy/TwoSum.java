package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Yongcong Lei on 8/21/2019
 */
public class TwoSum {

    /**
     * Solution in discussion: Tricky way to manually implement a kind of hash table by using &2047 (similar with mod-2048, but negative mod will return a negative number)
     * The solution works when inputs are in range [0, 2047]. It doesn't work when there is a collision.
     *
     * ex. nums = [2048, 0, 2048], target = 4096.
     * Expected result would be [0, 2], but the result returned is [0, 1]
     * Time: 0 ms
     * Memory: 38 MB
     */
    public static int[] twoSumTricky(int []nums, int target){
        int[] test = new int[2048];
        for (int i = 0; i < nums.length; i++) {
            int temp = (target - nums[i]) & 2047;
            if (test[temp] != 0) {
                return new int[]{test[temp] - 1, i};
            }
            test[nums[i] & 2047] = i + 1;
        }

        throw new IllegalArgumentException("no two sum");
    }

    /**
     * Third attempt: one-pass hash table (inspired by Leetcode Solution)
     * 
     * Time: 1 ms
     * Memory: 38 MB
     */
    public static int[] twoSumWithOnePassHash(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];

            if(numMap.containsKey(complement)){
                // the complement must have been stored in hash table,
                // which means it appear ahead of the current index i.
                return new int[]{numMap.get(complement), i};
            } else {
                numMap.put(nums[i], i);
            }
        }


        throw new IllegalArgumentException("No suitable elements");
    }


    /**
     * Second attempt: two-pass hash table
     *
     * 1. ignore the scenerio that there can be two same number in the array
     */
    public static int[] twoSumWithTwoPassHash(int[] nums, int target){
        Map<Integer, Integer> numMap = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            numMap.put(nums[i], i);
        }

        for(int i=0; i<nums.length; i++){
            int complement = target-nums[i];
            if(numMap.containsKey(complement) && numMap.get(complement)!=i){
                return new int[]{i, numMap.get(complement)};
            }
        }

        throw new IllegalArgumentException("No suitable elements");
    }

    /**
     * First attempt: Inelegant solution
     *
     *  The solution with sorting and two pointers doesn't work because the result is
     *  the index of two numbers in the original array. O
     *
     *  Once we sort it, we lost the original index unless we save it before sorting, which is kind of troublesome and inelegant
     */
    public static int[] twoSumWithSort(int[] nums, int target) {
        int[] sortedArr =  Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);

        int first = 0;
        int last = sortedArr.length - 1;

        while(first < last) {
            if(sortedArr[first] + sortedArr[last] == target){
                break;
            }
            else if(sortedArr[first] + sortedArr[last] < target) {
                first++;
            } else if(sortedArr[first] + sortedArr[last] > target){
                last--;
            }
        }

        if(first >= last)
            throw new IllegalArgumentException("No two sum");

        int firstNum = sortedArr[first];
        int complement = sortedArr[last];
        int result[] = new int[2];
        for(int i=0; i<nums.length; i++){
            if(nums[i] == firstNum)
                result[0] = i;
        }
        for(int j=nums.length-1; j>=0; j--){
            if(nums[j] == complement)
                result[1] = j;
        }

        return result;
    }
}
