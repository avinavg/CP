package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Leetcode1657 {

    public static void main(String[] args) {

    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        Map<Character, Long> charFreqMap1 = word1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> charFreqMap2 = word2.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        if (!charFreqMap1.keySet().equals(charFreqMap2.keySet())) return false;

        // Sort frequency lists and compare
        List<Long> freq1 = new ArrayList<>(charFreqMap1.values());
        List<Long> freq2 = new ArrayList<>(charFreqMap2.values());

        Collections.sort(freq1);
        Collections.sort(freq2);

        return freq1.equals(freq2);


    }
}
