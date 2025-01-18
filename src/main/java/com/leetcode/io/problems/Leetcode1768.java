package com.leetcode.io.problems;

public class Leetcode1768 {
    public static void main(String[] args) {

    }

    static String mergeAlternately(String word1, String word2) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int j = 0;
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
                i++;
            }
            if (j < word2.length()) {
                sb.append(word2.charAt(j));
                j++;
            }
        }
        return sb.toString();
    }
}
