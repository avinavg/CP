package com.leetcode.io.problems;

public class Leetcode135 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));

    }

    public static int candy(int[] a) {
        int candyCOUNT = 1;
        int candyPrev = 1;
        int candyNext = 1;
        int candy = 1;
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i + 1] > a[i]) {
                candyNext = candy + 1;
            } else if (a[i + 1] < a[i]) {
                candy = candyNext + 1;
                if (a[i - 1] > a[i] && candyPrev <= candy) {
                    candyCOUNT = candyCOUNT + candy + (candy - candyPrev + 1);
                }
            }
            candyCOUNT += candy;
            candyPrev = candy;
        }
        return candyCOUNT;
    }
}
