package com.leetcode.io.problems;

public class Leetcode35 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
    }

    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int start = 0;
        int end = length - 1;
        return search(start, end, nums, target);
    }

    private static int search(int start, int end, int[] nums, int target) {
        int mid = start + (end - start) / 2;
        if (target == nums[start]) {
            return start;
        }
        if (target == nums[end]) {
            return end;
        }
        if (end - start == 1 || end - start == 0) {
            if (target > nums[end]) {
                return end + 1;
            } else if (target < nums[start]) {
                return start;
            } else {
                return end;
            }
        }
        if (target == nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            return search(mid + 1, end, nums, target);
        } else if (target < nums[mid]) {
            return search(start, mid - 1, nums, target);
        }
        return 0;
    }
}
