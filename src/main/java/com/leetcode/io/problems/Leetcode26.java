package com.leetcode.io.leetcode;

import static java.util.Arrays.sort;

public class Leetcode26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeDuplicates(nums, val); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public static int removeDuplicates(int[] nums, int val) {
        int index = 0;
        for (int i = 1; i < nums.length-1; i++) {
           if(nums[index]!=nums[i]){
               nums[++index]=nums[i];
           }
        }
        return index + 1;
    }

}
