package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.Map;

public class Leetcode242 {
    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int value = charMap.getOrDefault(s.charAt(i), 0);
            charMap.put(s.charAt(i), ++value);
        }
        for (int i = 0; i < t.length(); i++) {
            if (charMap.get(t.charAt(i)) == null || charMap.get(t.charAt(i)) <= 0) {
                return false;
            }
            int value = charMap.get(t.charAt(i));
            charMap.put(t.charAt(i), value - 1);
        }
        for (int val : charMap.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            if (s.indexOf(t.charAt(i)) != -1) {
                s = s.replaceFirst(String.valueOf(t.charAt(i)), "-");
            } else {
                return false;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '-') {
                return false;
            }
        }
        return true;
    }

}
