package com.leetcode.io.problems;

public class Leetcode605 {

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));

    }

    public static boolean canPlaceFlowers(int[] a, int n) {
        int i = 1;
        int count = 0;
        for (i = 0; i <= a.length - 1; i++) {
            if (a[i] == 0) {
                if (checkNeighbour(a, i)) {
                    a[i] = 1;
                    count++;
                }
            }
            if (count > n) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkNeighbour(int[] a, int i) {
        if (a.length < 2) {
            return a[0] == 0;
        }
        if (i == 0) {
            return a[1] == 0;
        }
        if (i == a.length - 1) {
            return a[a.length - 2] == 0;
        }
        return a[i + 1] == 0 && a[i - 1] == 0;
    }

}
