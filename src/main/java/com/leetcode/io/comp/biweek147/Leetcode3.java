package com.leetcode.io.comp.biweek147;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {
    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 4, 2, 1};
        System.out.println(longestNonIncreasingDiffSubsequence(nums));

    }

    public static int longestNonIncreasingDiffSubsequence(int[] nums) {
        int[] nums1 = nums;

        int n = nums1.length;
        if (n == 1) return 1;

        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            dp.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums1[i] - nums1[j]);
                dp.get(i).put(diff, Math.max(dp.get(i).getOrDefault(diff, 0), 2));
                for (Map.Entry<Integer, Integer> entry : dp.get(j).entrySet()) {
                    int prevDiff = entry.getKey();
                    int length = entry.getValue();

                    if (diff <= prevDiff) {
                        dp.get(i).put(diff, Math.max(dp.get(i).get(diff), length + 1));
                    }
                }
            }
            for (int len : dp.get(i).values()) {
                maxLength = Math.max(maxLength, len);
            }
        }

        return maxLength;
    }
}
