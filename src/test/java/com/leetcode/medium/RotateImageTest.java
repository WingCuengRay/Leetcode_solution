package com.leetcode.medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class RotateImageTest {

    @Test
    public void rotate() {
        RotateImage rotateImage = new RotateImage();

        int[] n1 = new int[] {1, 2, 3};
        int[] n2 = new int[] {4, 5, 6};
        int[] n3 = new int[] {7, 8, 9};

        int [][] m = new int[][] {n1, n2, n3};
        rotateImage.rotate(m);

        int []r1 = new int[] {7, 4, 1};
        int []r2 = new int[] {8, 5, 2};
        int []r3 = new int[] {9, 6, 3};

        int [][]r = new int[][] {r1, r2, r3};

        assertArrayEquals(r, m);
    }

    @Test
    public void rotate2() {
        RotateImage rotateImage = new RotateImage();

        int[] n1 = new int[] {1, 2, 3, 4};
        int[] n2 = new int[] {5, 6, 7, 8};
        int[] n3 = new int[] {9, 10, 11, 12};
        int[] n4 = new int[] {13, 14, 15, 16};

        int [][] m = new int[][] {n1, n2, n3, n4};
        rotateImage.rotate(m);


        int[] r1 = new int[] {13, 9, 5, 1};
        int[] r2 = new int[] {14, 10, 6, 2};
        int[] r3 = new int[] {15, 11, 7, 3};
        int[] r4 = new int[] {16, 12, 8, 4};

        int [][]r = new int[][] {r1, r2, r3, r4};

        assertArrayEquals(r, m);
    }

}