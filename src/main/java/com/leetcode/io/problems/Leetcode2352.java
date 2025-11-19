package com.leetcode.io.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode2352 {

    public static void main(String[] args) {
        int[][] grid = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };


        int result = equalPairs(grid);
        System.out.println("Equal Pairs: " + result);
    }

    public static int equalPairs(int[][] grid) {
        int count = 0;

        Map<String, Integer> rowFreq = new HashMap<>();

        for (int[] rows : grid) {
            String hash = Arrays.toString(rows);
            String hashKey = hash.substring(1, hash.length() - 1);
            rowFreq.put(hashKey, rowFreq.getOrDefault(hashKey, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            StringBuilder columnHash = new StringBuilder();

            for (int j = 0; j < grid[0].length; j++) {
                columnHash.append(grid[j][i]).append(", ");
            }
            String columnHashKey = columnHash.substring(0, columnHash.length() - 2);

            count += rowFreq.getOrDefault(columnHashKey, 0);
        }
        return count;
    }
}
