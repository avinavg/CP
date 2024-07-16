package com.leetcode.io.leetcode;

public class Leetcode28 {
    public static void main(String[] args) {
        System.out.println(strStr("a", "a"));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0;
        while (i <= haystack.length() - needle.length()) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
