package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1679 {

    public static void main(String[] args) {
        System.out.println(maxOperations(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2));

    }

    public static int maxOperations(int[] nums, int k) {
        int toReturn = 0;

        Map<Integer, Integer> numFreqMap = new HashMap<>();
        for (int n : nums) {
            numFreqMap.put(n, numFreqMap.getOrDefault(n, 0) + 1);
        }
        for (int e : numFreqMap.keySet()) {
            int complement = k - e;
            if (complement == e) {
                int pairs = numFreqMap.get(complement) / 2;
                numFreqMap.replace(complement, numFreqMap.get(complement) - pairs * 2);
                toReturn += pairs;
            } else if (numFreqMap.getOrDefault(complement, 0) > 0 && (numFreqMap.get(e) > 0)) {
                int minPairs = Math.min(numFreqMap.get(e), numFreqMap.get(complement));
                numFreqMap.replace(e, numFreqMap.get(e) - minPairs);
                numFreqMap.replace(complement, numFreqMap.get(complement) - minPairs);
                toReturn += minPairs;
            }
        }
        return toReturn;
    }
}
