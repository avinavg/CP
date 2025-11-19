package com.leetcode.io.problems;

public class Leetcode1732 {

    public static void main(String[] args) {
        System.out.println(largestAltitude(new int[]{-5, 1, 5, 0, -7}));

    }

    static int largestAltitude(int[] gain) {

        int alt = 0;
        int maxAlt = 0;
        for (int i : gain) {
            alt += i;
            maxAlt = Math.max(maxAlt, alt);
        }
        return maxAlt;
    }
}
