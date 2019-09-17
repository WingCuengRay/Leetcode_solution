package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreeSumClosestTest {

    @Test
    public void threeSumClosest() {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();

        int result = threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);

        assertEquals(2, result);
    }
}