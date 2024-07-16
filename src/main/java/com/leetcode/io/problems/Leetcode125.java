package com.leetcode.io.leetcode;

public class Leetcode125 {

    public static void main(String[] args) {
        System.out.println(sanitize("0p"));

    }

    public static boolean sanitize(String s) {
        s = s.toLowerCase();
        int end = s.length() - 1;
        int start = 0;
        boolean charRefreshed;

        while (start <= end) {
            charRefreshed = false;
            char startC = s.charAt(start);
            char endC = s.charAt(end);

            if ((startC < 97 || startC > 122) && (startC > 57 || startC < 48)) {
                start++;
                charRefreshed = true;
            }
            if ((endC < 97 || endC > 122) && (endC > 57 || endC < 48)) {
                end--;
                charRefreshed = true;
            }
            if (!charRefreshed) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }


    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) {
            return true;
        }
        if (s.charAt(0) == (s.charAt(len - 1))) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

}
