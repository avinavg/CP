package com.leetcode.io.problems;

import static java.util.Arrays.sort;

public class Leetcode27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = {0, 1, 4, 0, 3}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeElementRevise(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    private static int removeElement(int[] nums, int val) {
        int fp = nums.length - 1;
        int lastValCounter = -1;
        int k = 0;
        while (fp >= 0) {
            int temp;
            if (nums[fp] == val) {
                if (lastValCounter == -1) {
                    swap(nums, nums.length - 1, fp);
                    lastValCounter = nums.length - 1;
                } else {
                    swap(nums, lastValCounter - 1, fp);
                    lastValCounter--;
                }
                k++;
            }
            fp--;
        }
        return nums.length - k;
    }

    private static int removeElementRevise(int[] nums, int val) {
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            if(nums[start]==val){
                swap(nums,start,end);
                end--; //shift end when swapped, dont need to do start++
            }else {
                start++; //only start when nums[start] is not val
            }
        }
        return start;
    }

    public static void swap(int[] a, int f, int l) {
        int temp;
        temp = a[f];
        a[f] = a[l];
        a[l] = temp;
    }
}
