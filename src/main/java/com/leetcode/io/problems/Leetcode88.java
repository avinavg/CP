package com.leetcode.io.leetcode;

public class Leetcode88 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        merge(nums1, 3, num2, num2.length);
    }

    public static void merge(int[] a, int m, int[] b, int n) {
        int fp = m-1;
        int sp = n-1;
        while (fp > 0 && sp > 0) {

            if (a[fp] < b[sp]) {
                insertAndShiftRight(a,b[sp],++fp);
                sp--;
            } else if (a[fp] > b[sp]) {
                insertAndShiftRight(a,b[sp],fp-1);
                sp--;
            } else {
            }
        }
        printArrayWithIndices(a);

        for (int iter = sp; iter < n; iter++) {
            System.out.println(fp);
            a[fp++] = b[sp++];
        }
        printArrayWithIndices(a);
    }


    public static void insertAndShiftRight(int[] a, int ele, int index) {
        for (int iter = a.length - 1; iter > index; iter--) {
            a[iter] = a[iter - 1];
        }
        a[index] = ele;
        printArrayWithIndices(a);

    }

    public static void printArrayWithIndices(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
}
