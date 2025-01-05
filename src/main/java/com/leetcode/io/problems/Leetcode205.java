package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charmap.get(s.charAt(i)) == null)
                if (!charmap.containsValue(t.charAt(i))) {
                    charmap.put(s.charAt(i), t.charAt(i));
                } else {
                    return false;

                }
            if (charmap.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }


    public static boolean isIsomorphicUsingtest(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        return testIso(s, t) && testIso(t, s);
    }

    static boolean testIso(String s, String t) {
        Map<Character, Character> charmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charmap.get(s.charAt(i)) == null) {
                charmap.put(s.charAt(i), t.charAt(i));
            }
            if (charmap.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
