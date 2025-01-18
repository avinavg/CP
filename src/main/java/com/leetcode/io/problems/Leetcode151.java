package com.leetcode.io.problems;

public class Leetcode151 {

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    static String reverseWords(String s) {
        String[] words = s.strip().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isBlank()) {
                sb.append(words[i] + " ");
            }
        }
        return sb.toString().strip();
    }
}
