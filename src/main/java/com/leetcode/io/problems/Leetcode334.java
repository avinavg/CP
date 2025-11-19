package com.leetcode.io.problems;

public class Leetcode334 {
    public static void main(String[] args) {
        System.out.println(new int[]{2, 1, 5, 0, 4, 6});

    }

    static boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        if (nums.length > 2) {
            for (int i = 1; i <= length - 2; i++) {
                if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean increasingTriplet2(int[] nums) {
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}