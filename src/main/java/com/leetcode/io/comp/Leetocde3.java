package com.leetcode.io.comp;

import java.util.*;
import java.util.stream.Collectors;

public class Leetocde3 {

    public static int countSpecialSubsequences(int[] nums) {
        int n = nums.length;
        int count = 0;


        Map<Integer, Integer> productCountMap = new HashMap<>();

        // Step 1: Count all (p, r) pairs where p < r
        // Store the product of nums[p] * nums[r] in the map
        for (int p = 0; p < n - 3; p++) {
            for (int r = p + 2; r < n - 1; r++) {
                int product = nums[p] * nums[r];
                productCountMap.put(product, productCountMap.getOrDefault(product, 0) + 1);
            }
        }

        // Step 2: Count valid (q, s) pairs where q < s, and check if the product matches any in productCountMap
        for (int q = 1; q < n - 2; q++) {
            for (int s = q + 2; s < n; s++) {
                int product = nums[q] * nums[s];
                // If the product exists in productCountMap, add the count
                if (productCountMap.containsKey(product)) {
                    count += productCountMap.get(product);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 3, 4, 3, 4, 3, 4};
        int result = countSpecialSubsequences(nums);
        System.out.println("Number of special subsequences: " + result);
    }
}
