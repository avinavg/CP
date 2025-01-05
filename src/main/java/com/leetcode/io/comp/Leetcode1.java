package com.leetcode.io.comp;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1 {
    public static void main(String[] args) {
        int[][] grid = {
                {3, 2},
                {1, 3},
                {3, 4},
                {0, 1}
        };

        int result = minimumOperations(grid);
        System.out.println("Minimum operations needed: " + result);
    }

    public static int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int lastele = grid[0][0];
        int operations = 0;
        int i = 0, j = 0;
        while (j < n) {
            while (i < m - 1) {
                if (grid[i][j] >= grid[i + 1][j]) {
                    lastele = grid[i + 1][j];
                    grid[i + 1][j] = grid[i][j] + 1;
                    operations += grid[i + 1][j] - lastele;

                }
                i++;
            }
            j++;
            i = 0;
        }
        return operations;
    }

    public static int minimumOperationschtgpt(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int operations = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                if (grid[i][j] <= grid[i - 1][j]) {
                    int increment = grid[i - 1][j] - grid[i][j] + 1;
                    grid[i][j] += increment;
                    operations += increment;
                }
            }
        }
        return operations;
    }

}