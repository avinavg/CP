package com.leetcode.io.problems;

public class Leetcode209 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

    }

    public static int minSubArrayLen(int target, int[] a) {

        int localSum = 0;
        int end = a.length;
        int start = 0;
        int curr = 0;
        int minLen = a.length;
        while (curr < end) {
            localSum += a[curr];
            if (localSum > target) {
                localSum = localSum - a[start];
                start++;
            }
            if ((localSum == target)) {
                minLen = Math.min(minLen, curr - start + 1);
                localSum = localSum - a[start];
                start++;
            }
            curr++;
        }
        return minLen;
    }
}
