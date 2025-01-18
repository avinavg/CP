package com.leetcode.io.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Leetcode228 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1, 2, 4, 5, 7}));

    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int curr = 0;
        int end = nums.length - 1;
        int rangeStart = 0;
        boolean rangeStarted = false;
        for (; curr < end; curr++) {
            if (nums[curr + 1] == nums[curr] + 1) {
                if (!rangeStarted) {
                    rangeStarted = true;
                    rangeStart = curr;
                }
            } else if (rangeStarted) {
                result.add("" + nums[rangeStart] + "->" + nums[curr]);
                rangeStarted = false;
            } else {
                result.add("" + nums[curr]);
            }
        }
        if (rangeStarted) {
            result.add("" + nums[rangeStart] + "->" + nums[curr]);

        } else {
            result.add("" + nums[curr]);
        }
        return result;
    }
}


//            if (rangeStarted) {
//                result.add(prev.toString() + "->" + nums[i - 1]);
//                prev = nums[i];
//                rangeStarted = false;
//            } else {
//                result.add("" + nums[i]);
//