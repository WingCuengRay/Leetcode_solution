package com.leetcode.category.interval;

import java.util.*;

public class MergeIntervals {

    /**
     * Merge intervals with graph - build a graph that a undirected connection exists if the two intervals can be merged
     *
     * Each cluster represents a single interval which can be merge by all the intervals in this cluster.
     *
     * Time Complexity: O(N^2 + N^2) = O(N^2) (the first one represents the complexity for building the graph, the second one for DFS)
     * Space Complexity: O(N^2) (graph)
     */
    public class MergeIntervals_Graph {
        public int[][] merge(int[][] intervals) {
            boolean[][] graph = buildGraph(intervals);

            List<int[]> result = dfsAndMerge(intervals, graph);
            return result.toArray(new int[result.size()][]);
        }

        private List<int[]> dfsAndMerge(int[][] intervals, boolean[][] graph) {
            final List<int[]> result = new ArrayList<>();
            final boolean[] hasVisited = new boolean[intervals.length];

            for(int i=0; i<hasVisited.length; i++) {
                if(!hasVisited[i]) {
                    int[] list = DFS(intervals, graph, hasVisited, i);
                    result.add(list);
                }
            }

            return result;
        }

        private int[] DFS(int[][] intervals, boolean[][] graph, boolean[] hasVisited, int start) {
            final Stack<Integer> stack = new Stack<>();
            int[] interval = null;

            stack.push(start);
            while (!stack.isEmpty()) {
                int node = stack.pop();

                if(!hasVisited[node]) {
                    hasVisited[node] = true;
                    interval = merge(interval, intervals[node]);

                    for(int k=0; k<intervals.length; k++) {
                        if(graph[node][k] && !hasVisited[k]) {
                            stack.push(k);
                        }
                    }
                }
            }

            return interval;
        }

        /**
         * Initialize a graph.
         * If two intervals say intervals[i] and interval[j] can be merged, graph[i][j] and graph[j][i] are true (undirected edge)
         * @param intervals
         * @return
         */
        private boolean[][] buildGraph(int [][] intervals) {
            boolean[][] graph = new boolean[intervals.length][];

            for(int i=0; i<intervals.length; i++) {
                graph[i] = new boolean[intervals.length];
            }

            for(int i=0; i<intervals.length; i++) {
                for(int j=i+1; j<intervals.length; j++) {
                    if(canMerge(intervals[i], intervals[j])) {
                        graph[i][j] = graph[j][i] = true;
                    }
                }
            }

            return graph;
        }

        private boolean canMerge(int[] first, int[] second) {
            return first[0] <= second[1] && second[0] <= first[1];
        }

        private int[] merge(int[] result, int[] second) {
            if(result == null) {
                return second;
            } else if(second[0] <= result[0] && second[1] >= result[0]) {
                result[0] = Math.min(second[0], result[0]);
                result[1] = Math.max(result[1], second[1]);
            } else if(second[0] <= result[1] && second[1] >= result[1]) {
                result[0] = Math.min(second[0], result[0]);
                result[1] = Math.max(result[1], second[1]);
            }

            return result;
        }

    }

    /**
     * Sort by the start point of an interval, and then merge
     *
     * Time: O(NlogN + N)
     * Space: O(1)
     */
    public class MergeIntervals_Sort_and_Merge {
        public int[][] merge(int[][] intervals) {
            if(intervals.length == 0) {
                return new int[0][];
            }

            Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0]));

            final List<int[]> result = new LinkedList<>();
            result.add(intervals[0]);

            for(int i=1; i<intervals.length; i++) {
                if(canMerge(result.get(result.size()-1), intervals[i])) {
                    merge(result.get(result.size()-1), intervals[i]);
                } else {
                    result.add(intervals[i]);
                }
            }

            return result.toArray(new int[result.size()][]);
        }

        private boolean canMerge(int[] first, int[] second) {
            return first[0] <= second[1] && second[0] <= first[1];
        }

        private void merge(int[] result, int[] second) {
            if(second[0] <= result[0] && second[1] >= result[0]) {
                result[0] = Math.min(second[0], result[0]);
                result[1] = Math.max(result[1], second[1]);
            } else if(second[0] <= result[1] && second[1] >= result[1]) {
                result[0] = Math.min(second[0], result[0]);
                result[1] = Math.max(result[1], second[1]);
            }
        }
    }
}
