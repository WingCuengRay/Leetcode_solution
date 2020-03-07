package com.leetcode.medium;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int []result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int idx = search(nums, 0, nums.length, target);
        if(idx == -1) {
            return result;
        }

        result[0] = idx;
        result[1] = idx;

        int end = idx;
        int firstIdx;
        do {
            firstIdx = search(nums, 0, end, target);
            if(firstIdx != -1)
                result[0] = firstIdx;
            end = firstIdx;
        } while(firstIdx != -1);

        int start = idx + 1;
        int lastIdx;
        do {
            lastIdx = search(nums, start, nums.length, target);
            if(lastIdx != -1)
                result[1] = lastIdx;
            start = lastIdx + 1;
        } while(lastIdx != -1);

        return result;
    }

    private int search(int []nums, int start, int end, int target) {
        if(start >= end) {
            return -1;
        }

        int mid = (start + end) / 2;
        if(nums[mid] == target) {
            return mid;
        } else if(target < nums[mid]) {
            return search(nums, start, mid, target);
        } else {
            return search(nums, mid+1, end, target);
        }
    }
}
