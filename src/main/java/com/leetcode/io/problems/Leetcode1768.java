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


    static String mergeAlternatelyRevise(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        StringBuilder sb = new StringBuilder(l1 + l2);
        int i = 0;
        for (; i < Math.min(l1, l2); i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        if (l1 > l2) {
            sb.append(word1, i + 1, l1 - 1);
        } else {
            sb.append(word2, i + 1, l1 - 1);
        }

        return sb.toString();
    }
}
