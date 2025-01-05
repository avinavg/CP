package com.leetcode.io.problems;

public class Leetcode283 {
    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 0, 3, 12};
        moveZeroes(a);
        System.out.println(a);
    }

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }

        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
