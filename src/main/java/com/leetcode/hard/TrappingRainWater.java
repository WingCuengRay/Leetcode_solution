package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TrappingRainWater {

    /**
     * Two pointer solution
     * @param height
     * @return
     */
    public int trap(int [] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        int sum = 0;
        while (left < right) {
            if(height[left] < height[right]) {
                if(height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }

        return sum;
    }

//    public int trap(int[] height) {
//        final int max = IntStream.of(height).max().orElse(0);
//        int sum = 0;
//        for(int i=1; i<=max; i++) {
//            List<Integer> result = findValuesGreaterThan(height, i);
//            if(result.size() < 2)
//                return sum;
//
//            sum += calculateWaterForHeight(height, result.get(0), result.get(result.size()-1), i);
//        }
//
//        return sum;
//    }

    private int calculateWaterForHeight(int[] height, int start, int end, int value) {
        int sum = 0;
        while(start <= end) {
            if(height[start] < value)
                sum++;
            start++;
        }

        return sum;
    }

    private List<Integer> findValuesGreaterThan(int []height, int value) {
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<height.length; i++) {
            if(height[i] >= value) {
                result.add(i);
            }
        }

        return result;
    }
}
