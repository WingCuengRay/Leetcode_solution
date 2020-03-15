package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeIntervalsTest {

    @Test
    public void merge() {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[] n1 = new int[]{1, 4};
        int[] n2 = new int[]{2, 3};
        int [][]arr = new int[][]{n1, n2};

        mergeIntervals.merge(arr);
    }
}