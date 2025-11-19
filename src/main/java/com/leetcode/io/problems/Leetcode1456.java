package com.leetcode.io.problems;

import java.util.Set;

public class Leetcode1456 {

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }

    public static int maxVowels(String s, int k) {
        Set<Character> vowelsSet = Set.of('a', 'e', 'i', 'o', 'u');

        char[] chars = s.toCharArray();
        int count = 0;
        int i = 0;
        for (; i < k; i++) {
            if (vowelsSet.contains(chars[i])) count++;
        }
        int max = count;
        for (i = k; i < s.length(); i++) {
            if (vowelsSet.contains(chars[i])) count++;
            if (vowelsSet.contains(chars[i - k])) count--;
            max = Math.max(max, count);
        }
        return max;
    }
}
