package com.leetcode.io.leetcode;

public class Leetcode167 {
    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2, 7, 11, 15},9));

    }

    public static int[] twoSum(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int sum = a[start] + a[end];
            if (sum == target) {
                return new int[]{start+1, end+1};
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{0, a.length - 1};
    }
}
