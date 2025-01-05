package com.leetcode.io.striver.arrays;

import javafx.util.Pair;

import java.util.*;

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
        Set<Integer> zerox = new HashSet<>();
        Set<Integer> zeroy = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zerox.add(i);
                    zeroy.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (zerox.contains(i) || zeroy.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
