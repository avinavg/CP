package com.leetcode.io.comp.biweek147;

public class Leetcode1 {
    public static void main(String[] args) {
        System.out.println(hasMatch("ill", "i*"));

    }

    public static boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        String preString = p.substring(0, index);
        String postString = p.substring(index + 1);
        if (preString.isBlank() && postString.isBlank()) {
            return true;
        }
        if (s.contains(preString)) {
            String subcheck = s.substring(s.indexOf(preString) + preString.length());
            return subcheck.contains(postString);
        }
        return false;
    }
}
