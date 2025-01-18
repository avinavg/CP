package com.leetcode.io.problems;

public class LeetCode392 {
    public static void main(String[] args) {
        System.out.println(isSubsequenceRevise("abk", "ahbgdc"));

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

    static boolean isSubsequenceRevise(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int iter1 = 0, iter2 = 0;
        while (iter1 < s.length() && iter2 < t.length()) {

            if (s.charAt(iter1) == t.charAt(iter2)) {
                iter1++;
            }
            iter2++;
        }
        return iter1 >= s.length();
    }
}
