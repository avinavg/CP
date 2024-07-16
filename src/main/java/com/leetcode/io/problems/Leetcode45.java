package com.leetcode.io.leetcode;

public class Leetcode45 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,0,2,0,1}));
    }

    private static int canJump(int[] a) {
        int nextJump = 0;
        int end = a.length;
        int jump = 0;
        int max = 0;
        for (int i = 0; i < end-1; i++) {
            max = Math.max(max, i + a[i]);
            if (i == nextJump) {
                nextJump = max;
                jump++;
            }
        }
        return jump;
    }
}
