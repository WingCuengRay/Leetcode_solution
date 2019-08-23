package com.leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

public class TwoSumTest {

    @Test
    public void twoSumWithHash() {
        int arr[] = new int[]{2,7,11,15};

        int result[] = TwoSum.twoSumWithOnePassHash(arr, 9);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void twoSumWithSort() {
    }

    @Test()
    public void twoSumTricky() {
        int arr[] = new int[]{2048, 0, 2048};

        int result[] = TwoSum.twoSumTricky(arr, 4096);
        assertArrayEquals(new int[]{0, 2}, result);
    }

    @Test
    public void twoSumWithOnePassHash() {
    }

    @Test
    public void twoSumWithTwoPassHash() {
    }
}