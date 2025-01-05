package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.List;

public class Leetcode55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{0, 1}));
    }

    private static boolean canJump(int[] a) {
        int len = a.length;
        if (a[0] == 0) {
            if (len == 1) { // If there's only one element in the array
                return true; // Return true as it's already at the last index
            } else {
                return false;
            }
        }
        List<Integer> zeroIndices = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (a[i] == 0) {
                zeroIndices.add(i);
            }
        }
        boolean canReach = true;
        int lastIndex = 0;
        for (int zeroIndex : zeroIndices) {
            for (int i = lastIndex; i < zeroIndex; i++) {
                if (a[i] < i + zeroIndex) {
                    canReach = false;
                }
            }

        }
        return true;
    }

    public static boolean canJumpBetter(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return true;
        }

        int maxReach = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= len - 1) {
                return true;
            }
        }

        return false;
    }
}
