package com.leetcode.medium;

import java.util.List;
import org.junit.Test;

public class ThreeSumTest {

    @Test
    public void threeSum() {
        ThreeSum threeSum = new ThreeSum();

        List<List<Integer>> result = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(result);

        result = threeSum.threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6});
        System.out.println(result);
    }
}