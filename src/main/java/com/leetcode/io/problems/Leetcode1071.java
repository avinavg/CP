package com.leetcode.io.problems;

public class Leetcode1071 {
    public static void main(String[] args) {

        System.out.println(gcdOfStrings("ABCABC", "ABCABCABCABC"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int endIndex = gcd(str1.length(), str2.length());
        System.out.println(endIndex);
        return str1.substring(0, endIndex);
    }

    private static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    private static boolean isRepeating(String str) {
        int n = str.length();
        for (int len = 1; len <= n / 2; len++) { // Try smaller repeating units
            if (n % len == 0) { // Only check lengths that evenly divide n
                String unit = str.substring(0, len);
                if (str.equals(unit.repeat(n / len))) {
                    return true;
                }
            }
        }
        return false;
    }

}
