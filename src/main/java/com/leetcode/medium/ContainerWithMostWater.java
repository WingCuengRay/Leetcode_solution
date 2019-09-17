package com.leetcode.medium;

/**
 * Created by Yongcong Lei on 9/13/2019
 *
 * Type:
 *      Problem analysis, Problem abstraction, Two pointer in action
 */
public class ContainerWithMostWater {
    public int maxArea(int []height){
        int i = 0;
        int j = height.length - 1;

        int max = 0;
        while(i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if(max < area)
                max = area;

            if(height[i] < height[j]) {
                int maxLeft = height[i];
                while(i < j && height[i] <= maxLeft )
                    i++;
            } else {
                int maxRight = height[j];
                while(i < j && height[j] <= maxRight )
                    j--;
            }
        }

        return max;
    }

    public int maxArea_Brute_Force(int[] height) {
        int max = 0;

        for(int i=1; i<height.length; i++){
            for(int j=0; j<i; j++) {
                int h = Math.min(height[i], height[j]);
                if(max < h * (i-j))
                    max = h * (i-j);
            }
        }

        return max;
    }
}
