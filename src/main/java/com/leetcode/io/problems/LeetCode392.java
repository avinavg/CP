package com.leetcode.io.leetcode;

public class LeetCode392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaaaa", "bbaaaa"));

    }

    static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(0) == t.charAt(i)) {
                return isSubsequence(s.substring(1), t.substring(i + 1));
            }
        }
        return false;
    }
}
