package com.leetcode.io.problems;

import java.util.*;

public class Leetcode2215 {

    public static void main(String[] args) {
        findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6});
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> nubers1 = new HashSet<>();
        Set<Integer> nubers2 = new HashSet<>();

        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length) {
                nubers1.add(nums1[i]);
            }
            if (j < nums2.length) {
                nubers2.add(nums2[i]);
            }
            i++;
            j++;
        }

        for (int num : nubers2) {
            if (!nubers1.contains(num)) {
                list1.add(num);
            }
        }
        for (int num : nubers1) {
            if (!nubers2.contains(num)) {
                list2.add(num);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(list2);
        result.add(list1);
        return result;
    }
}
