package com.leetcode.io.leetcode;

import java.util.Arrays;

public class Leetcode73 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        System.out.println("Original matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        setZeroes(matrix);

        System.out.println("\nMatrix after calling setZeroes:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {
        int zerox[] = new int[matrix.length];
        int zeroy[] = new int[matrix[0].length];
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroy[k] = i;
                    zerox[k++] = j;
                }
            }
        }
        for(int i=0; i<k;i++){
            Arrays.fill(matrix[zerox[i]],0,matrix[zerox[i]].length,0);
        }

    }
}
