package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinationSum = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum(candidates, 0, target, new ArrayList<>(), combinationSum);

        return combinationSum;
    }

    public void combinationSum(int[] candidates, int k, int target, List<Integer> result, List<List<Integer>> combinations) {
        if(target == 0){
            combinations.add(new ArrayList<>(result));
            return;
        }

        for(int i=k; i<candidates.length && candidates[i] <= target; i++) {
            result.add(candidates[i]);
            combinationSum(candidates, i, target - candidates[i], result, combinations);
            result.remove(result.size()-1);
        }

        return;
    }


}
