package com.leetcode.io.microsoft;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{3, 2, 4}, 6));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numIndexMap.containsKey(complement)) {
                return new int[]{numIndexMap.get(complement), i}; // Found the pair
            }
            numIndexMap.put(nums[i], i); // Store the index of the current number
        }
        return new int[]{}; // No valid pair found
    }
}
