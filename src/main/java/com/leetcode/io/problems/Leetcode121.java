package com.leetcode.io.leetcode;

public class Leetcode121 {
    public static void main(String[] args) {
        System.out.println(maxProfitRevise(new int[]{7, 5, 3, 6, 4}));
    }

    private static int maxProfit(int[] a) {
        int bp = 0, cp = 0, maxGross = 0, diff = 0;
        while (bp < a.length-1) {
            diff = a[bp] - a[cp];
            if (diff > 0) {
                maxGross = Math.max(maxGross, diff);
            } else {
                cp = bp;
            }
            bp++;
        }
        return maxGross;
    }

    private static int maxProfitRevise(int[] a) {
        int buyingPrice = a[0];
        int maxProfit = 0;
        for (int value : a) {
            if (buyingPrice > value) {
                buyingPrice = value;
            }
            if (value - buyingPrice > maxProfit) {
                maxProfit = value - buyingPrice;
            }
        }
        return maxProfit;
    }
}
