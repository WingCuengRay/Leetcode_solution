package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> eachList: result) {
                for(int i=0; i<eachList.size()+1; i++) {
                    List<Integer> list = new ArrayList<>(eachList);
                    list.add(i, num);
                    tmp.add(list);
                }
            }

            result = tmp;
        }

        return result;
    }

    public List<List<Integer>> permute_recursion(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permute_recursion(nums, 0, result);
        return result;

    }

    void permute_recursion(int []nums, int start, List<List<Integer>> result) {
        if(start == nums.length - 1) {
            List<Integer> list = new ArrayList<>();
            for(int num: nums)
                list.add(num);
            result.add(list);
            return;
        }

        for(int i=start; i<nums.length; i++) {
            swap(nums, i, start);
            permute_recursion(nums, start+1, result);
            swap(nums, i, start);
        }
    }

    private void swap(int []nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
