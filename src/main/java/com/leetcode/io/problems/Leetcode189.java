package com.leetcode.io.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode189 {
    public static void main(String[] args) {
        printArrayWithIndices(shiftRightRevise(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 79, 76}, 3));
    }

    public static int[] rotate(int[] nums, int k) {
        shiftRight(nums, k % nums.length);
        return nums;
    }

    public static int[] shiftRightRevise(int[] a, int mod){
        int[] b = new int[a.length];
        int k=0;
        for(int i = a.length-mod; i<a.length;i++){
            b[k++]=a[i];
        }
        for(int i =0;i<a.length-mod;i++){
            b[k++]=a[i];
        }
        return b;
    }


    public static void shiftRight(int[] a, int mod) {
        List<Integer> spareList = new ArrayList();
        for (int i = a.length - mod; i < a.length; i++) {
            spareList.add(a[i]);
        }
        if (a.length - mod >= 0) System.arraycopy(a, 0, a, mod, a.length - mod);
        int i = 0;
        for (int ele : spareList) {
            a[i++] = ele;
        }
    }

    public static void printArrayWithIndices(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }

}
