package com.leetcode.io.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueindexMap = new HashMap<>();
        int index = 0;
        for (int i : nums) {
            valueindexMap.put(i, index);
        }
        for (int i : nums) {
            if (valueindexMap.containsKey(target - i)) {
                return new int[]{valueindexMap.get(i), valueindexMap.get(target - i)};
            }
        }
        return new int[]{};
    }

}
