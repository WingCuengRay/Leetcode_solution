package com.leetcode.medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContainerWithMostWaterTest {

    @Test
    public void maxArea_Brute_Force() {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        int []height = {1,8,6,2,5,4,8,3,7};
        int result = containerWithMostWater.maxArea_Brute_Force(height);
        assertEquals(49, result);
    }

    @Test
    public void maxArea() {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        int []height = {1,8,6,2,5,4,8,3,7};
        int result = containerWithMostWater.maxArea(height);
        assertEquals(49, result);

    }
}