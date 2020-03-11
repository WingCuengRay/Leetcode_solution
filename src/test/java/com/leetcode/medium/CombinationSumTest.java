package com.leetcode.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CombinationSumTest {

    @Test
    public void combinationSum() {
        CombinationSum combinationSum = new CombinationSum();

        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);

        candidates = new int[]{2, 3, 5};
        target = 8;
        result = combinationSum.combinationSum(candidates, target);
        System.out.println(result);

    }
}