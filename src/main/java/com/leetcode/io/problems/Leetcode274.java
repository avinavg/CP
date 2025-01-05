package com.leetcode.io.problems;

import java.util.Arrays;

public class Leetcode274 {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{8, 5, 3, 3, 3, 2, 1, 1}));
    }

    private static int hIndex(int[] a) {
        Arrays.sort(a);
        int len = a.length;
        if (a[0] > len) {
            return len;
        }
        for (int i = 0; i < len; i++) {
            int count = len-i;
            if (a[i]>= count) {
                return Math.min(a[i], a.length - i);
            }
        }
        return 0;
    }

    public static int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;
        for (int i = 0; i < n; i++) {
            int count = n - i;
            if (citations[i] >= count) {
                hIndex = Math.max(hIndex, count);
            }
        }
        return hIndex;
    }
}
