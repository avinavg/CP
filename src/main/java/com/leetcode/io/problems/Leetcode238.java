package com.leetcode.io.problems;

public class Leetcode238 {

    public static void main(String[] args) {
        System.out.println(productExceptSelf2(new int[]{6, 4, 7, 2, 5}));
    }

    public int[] productExceptSelf(int[] a) {
        int product = 1;
        boolean zeroFound = false;
        boolean productUpdated = false;

        for (int value : a) {
            if (value != 0) {
                product *= value;
                productUpdated = true;
            } else {
                if (zeroFound) {
                    product = 0;
                }
                zeroFound = true;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (!zeroFound) {
                a[i] = product / a[i];
            } else {
                if (a[i] == 0 && productUpdated) {
                    a[i] = product;
                } else {
                    a[i] = 0;
                }
            }
        }

        return a;
    }

    public static int[] productExceptSelf2(int[] a) {
        int len = a.length;
        int[] f = new int[len];
        int[] b = new int[len];
        f[0] = a[0];
        b[len - 1] = a[len - 1];
        for (int i = 1; i < len; i++) {
            f[i] = f[i - 1] * a[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            b[i] = b[i + 1] * a[i];
        }
        a[0] = b[1];
        a[len - 1] = f[len - 2];
        for (int i = 1; i <= len - 2; i++) {
            a[i] = f[i - 1] * b[i + 1];
        }
        return a;
    }


}