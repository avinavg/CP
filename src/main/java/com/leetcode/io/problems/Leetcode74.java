package com.leetcode.io.problems;

public class Leetcode74 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 13;
        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);

    }

//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int start = 0;
//        int end = matrix.length;
//        int row = getRow(start, end - 1, matrix, target);
//        int number = search(0, matrix[0].length, matrix[row], target);
//        return number != -1;
//    }
//
//    private static int getRow(int start, int end, int[][] nums, int target) {
//        int mid = start + (end - start) / 2;
//        if (end - start == 0) {
//            return start;
//        }
//        if (start - end == 1) {
//            return nums[end][1] > target ? start : end;
//        }
//        if (target == nums[mid][0]) {
//            return mid;
//        } else if (target > nums[mid][0]) {
//            return getRow(mid + 1, end, nums, target);
//        } else if (target < nums[mid][0]) {
//            return getRow(start, mid - 1, nums, target);
//        }
//        return 0;
//    }
//
//    private static int search(int start, int end, int[] nums, int target) {
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                return mid;
//            } else if (nums[mid] < target) {
//                start = mid + 1;
//            } else {
//                end = mid - 1;
//            }
//        }
//        return -1;
//    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length;
        int row = getRow(start, end - 1, matrix, target);
        if (row == -1) return false;
        int number = search(0, matrix[0].length, matrix[row], target);
        return number != -1;
    }

    private static int getRow(int start, int end, int[][] matrix, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[0].length - 1]) {
                return mid; // Target is within this row's range
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1; // Target not in any row
    }

    private static int search(int start, int end, int[] nums, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
