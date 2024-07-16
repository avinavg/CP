package com.leetcode.io.leetcode;

public class Leetcode14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        String referenceString = strs[0];
        for (String s : strs) {
            int i = 0;
            for (; i < s.length() && i < referenceString.length(); i++) {
                if (s.charAt(i) != referenceString.charAt(i)) {
                    referenceString = s.substring(0, i);
                }
            }
            if (referenceString.length() == 0) {
                break;
            }
            if (referenceString.length() != 0 && referenceString.length() > s.length()) {
                referenceString = s;
            }
        }
        return referenceString;
    }

}
