package com.leetcode.category.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    /**
     * Time Complexity: O(N)
     */
    public class InsertInterval_BruteForce {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> result = new ArrayList<>();
            int i;
            for (i = 0; i < intervals.length && intervals[i][0] < newInterval[0]; i++) {
                result.add(intervals[i]);
            }

            if(!result.isEmpty() && isOverLapped(newInterval, result.get(result.size() - 1))) {
                result.set(result.size() - 1, merge(result.get(result.size() - 1), newInterval));
            } else {
                result.add(newInterval);
            }

            boolean canMerge = true;
            for(int j = i; j<intervals.length; j++) {
                if(canMerge && isOverLapped(intervals[j], result.get(result.size() - 1))) {
                    result.set(result.size() - 1, merge(result.get(result.size() - 1), intervals[j]));
                } else {
                    result.add(intervals[j]);
                    canMerge = false;
                }
            }

            return result.toArray(new int[result.size()][]);
        }

        private int[] merge(int[] a, int[] b) {
            int [] merged = new int[2];

            merged[0] = Math.min(a[0], b[0]);
            merged[1] = Math.max(a[1], b[1]);

            return merged;
        }

        private boolean isOverLapped(int[] a, int[] b) {
            if(a[1] < b[0] || b[1] < a[0]){
                return false;
            } else {
                return true;
            }
        }
    }

}
