package com.leetcode.io.problems;

public class Leetcode1004 {

    public static void main(String[] args) {
        System.out.println(longestOnes2(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    public static int longestOnes(int[] a, int z) {
        int max = 0;
        int zleft = z;
        int k = 0;
        int start = 0;
        while (k < a.length) {
            if (a[k] == 0) {
                if (zleft > 0) {
                    zleft--;
                } else {
                    if (a[start] == 0) {
                        start++;
                    } else {
                        while (a[start] == 1) {
                            start++;
                        }
                        start++;
                    }
                }
            }
            k++;
            max = Math.max(max, k - start);
        }
        return max;
    }

    public static int longestOnes2(int[] a, int z) {
        int max = 0;
        int start = 0;  // Start of the sliding window
        int zeroCount = 0;

        for (int end = 0; end < a.length; end++) {
            if (a[end] == 0) zeroCount++;

            while (zeroCount > z) {
                if (a[start] == 0) zeroCount--;
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}
