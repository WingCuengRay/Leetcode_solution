package com.leetcode.interval;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    /**
     * The problem can be reduced to Activity Selection Problem.
     * "Choose the minimum numbers of interval to be removed to make the rest non-overlapping" == "Choose maximum numbers of intervals that are not overlapping".
     * The Activity Selection Problem was taught in the course and can be solved with greedy algorithm: **Greedily choose the interval with earliest finish time**.
     */
    public class NonOverlappingIntervals_reduce {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparing(arr -> arr[1]));

            int endpoint = Integer.MIN_VALUE;
            int cnt = 0;
            for (int i = 0; i < intervals.length; i++) {
                if(intervals[i][0] >= endpoint) {
                    cnt++;
                    endpoint = intervals[i][1];
                }
            }

            return intervals.length - cnt;
        }
    }

    /**
     * Greedy algorithm: Sort, and then delete the interval with larger end value if overlapped
     * <p>
     * Time Complexity: O(NlogN) (sorting)
     * Space complexity: O(1)
     * <p>
     * reference: http://web.stanford.edu/class/archive/cs/cs161/cs161.1176/Sections/final_review-1.pdf
     */
    public class NonOverlappingIntervals_Greedy {
        public int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

            int cnt = 0;
            int curr = 0;
            int i = curr + 1;
            while (i < intervals.length) {
                if (overlapped(intervals[curr], intervals[i])) {
                    cnt++;
                    if (intervals[curr][1] <= intervals[i][1]) {
                        i++;
                    } else if (intervals[curr][1] > intervals[i][1]) {
                        curr = i;
                        i = curr + 1;
                    }
                } else {
                    curr = i;
                    i = curr + 1;
                }
            }

            return cnt;
        }

        private boolean overlapped(int[] a, int[] b) {
            if (a[1] <= b[0] || b[1] <= a[0]) {
                return false;
            } else {
                return true;
            }
        }
    }


}
