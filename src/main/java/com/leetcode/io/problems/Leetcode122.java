package com.leetcode.io.leetcode;

public class Leetcode122 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //find peaks and buy/sell
    private static int maxProfit(int[] a) {
        int bp = 0, maxGross = 0, diff = 0;
        while (bp < a.length - 1) {
            diff = a[bp + 1] - a[bp];
            System.out.println("current is : " + a[bp] + " next is : " + a[bp + 1] + " diff is : " + diff);
            if (diff > 0) {
                maxGross += diff;
            }
            bp++;
        }
        return maxGross;
    }
}