package com.leetcode.io.problems;

import java.util.Arrays;

public class Leetcode875 {

    public static void main(String[] args) {
        Leetcode875 obj = new Leetcode875();

        System.out.println(obj.minEatingSpeed(new int[]{11, 7, 6, 3}, 8));

    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = (int) Math.ceil(Arrays.stream(piles).sum() / h);
        int high = Arrays.stream(piles).max().getAsInt();

        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;

            for (int pile : piles) {
                count += Math.ceil((double) pile / mid);
            }

            if (count <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
