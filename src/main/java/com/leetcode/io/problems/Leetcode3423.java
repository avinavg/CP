package com.leetcode.io.problems;

public class Leetcode3423 {
    public static void main(String[] args) {
        maxAdjacentDistance(new int[]{1, -5});
    }

    static int maxAdjacentDistance(int[] nums) {
        int diff = 0;
        int length = nums.length;

        for (int i = 1; i < nums.length; i++) {
            diff = Math.max(diff, Math.abs(nums[i] - nums[i - 1]));
        }
        return Math.max(diff, Math.abs(nums[0] - nums[length - 1]));
    }
}
