package com.leetcode.io.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode1207 {

    public static void main(String[] args) {

    }


    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numFreqMap = Arrays.stream(arr).boxed().collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));

        Set<Integer> freqSet = (Set<Integer>) numFreqMap.values();

        return freqSet.size() == numFreqMap.size();

    }

}
