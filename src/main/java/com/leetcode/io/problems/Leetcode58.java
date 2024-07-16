package com.leetcode.io.leetcode;

public class Leetcode58 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    public static int lengthOfLastWordUsingArray(String s) {
        String[] strings = s.split(" ");
        return strings[strings.length - 1].length();
    }

    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int i = len - 1;
        int res = 0;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                break;
        }
        for (; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            res++;
        }
        return res;
    }
}
