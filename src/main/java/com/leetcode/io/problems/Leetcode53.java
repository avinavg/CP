package com.leetcode.io.problems;

import static java.lang.Integer.max;

public class Leetcode53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public static int maxSubArray(int[] a) {

        int max = a[0];
        int currMax = a[0];
        for (int i = 1; i < a.length; i++) {
            max = max(a[i], max + a[i]);
            currMax = max(max, currMax);
        }
        return currMax;
    }
}
