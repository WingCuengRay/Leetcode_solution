package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindFirstandLastPositionofElementinSortedArrayTest {

    @Test
    public void searchRange() {
        FindFirstandLastPositionofElementinSortedArray solution = new FindFirstandLastPositionofElementinSortedArray();
        int arr[];
        int result[];

        arr = new int[] {5,7,7,8,8,10};
        result = solution.searchRange(arr, 8);
        assertArrayEquals(new int[]{3,4}, result);

        arr = new int[] {5,7,7,8,8,10};
        result = solution.searchRange(arr, 6);
        assertArrayEquals(new int[]{-1, -1}, result);
    }
}