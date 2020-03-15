package com.leetcode.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }

//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//
//        for(int i=0; i<n; i++) {
//            for(int j=0; j<n-i; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n-1-j][n-1-i];
//                matrix[n-1-j][n-1-i] = tmp;
//            }
//        }
//
//        for(int i=0; i<n/2; i++){
//            for(int j=0; j<n; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[n-1-i][j];
//                matrix[n-1-i][j] = tmp;
//            }
//        }
//    }

//    public void rotate(int[][] matrix) {
//        int n = matrix.length;
//        for (int i = 0; i < n / 2; i++) {
//            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n-1-j][i];
//                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
//                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
//                matrix[j][n-1-i] = temp;
//            }
//        }
//    }
}
