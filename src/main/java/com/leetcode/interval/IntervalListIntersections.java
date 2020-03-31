package com.leetcode.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length) {
            int [] overlapped = getOverLapped(A[i], B[j]);

            if(overlapped != null) {
                result.add(overlapped);
            }

            if(A[i][1] > B[j][1]) {
                j++;
            } else if(A[i][1] < B[j][1]) {
                i++;
            } else {
                i++;
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private int[] getOverLapped(int[] a, int[] b) {
        if(a[1] < b[0] || b[1] < a[0]) {
            return null;
        }

        int[] overlap = new int[2];
        overlap[0] = Math.max(a[0], b[0]);
        overlap[1] = Math.min(a[1], b[1]);
        return overlap;
    }
}
