package com.leetcode.io.leetcode;

import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class Leetcode80 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3}; // Input array
        int val = 2; // Value to remove
        int[] expectedNums = {0, 1, 2, 3, 4}; // The expected answer with correct length.
        // It is sorted with no values equaling val.

        int k = removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < expectedNums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }


    public static int removeDuplicates(int[] nums) {
       return 0;
    }

    public static int removeDuplicatesShift(int[] nums) {
        int start = 1;
        int end = nums.length - 2;
        int count = 0;
        while (start <= end) {
            if (nums[start - 1] == nums[start] && nums[start + 1] == nums[start]) {
                count++;
                leftShift(nums, start, end + 1);
                end--;
            } else {
                start++;
            }
        }
        return nums.length - count ;
    }

    private static void leftShift(int[] a, int start, int end) {
        int temp = a[start];
        for (int i = start; i < end; i++) {
            a[i] = a[i + 1];
        }
        a[end] = temp;
    }


    public static int removeDuplicatesMap(int[] nums) {
        Map<Integer, Integer> keyToFreq = new TreeMap<>();
        int index = 0;
        for (int num : nums) {
            keyToFreq.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> key : keyToFreq.entrySet()) {
            int value = key.getValue();
            int endindex = value > 2 ? index + 2 : index + value;
            fill(nums, index, endindex, key.getKey());
            index = endindex;

        }
        return index;
    }
}
