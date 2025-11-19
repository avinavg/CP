package com.leetcode.io.microsoft;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("njajfnia23"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        int toReturn = 0;
        boolean isPositive = true;
        boolean numberFound = false;

        int i = 0;
        if (s.charAt(i) == '-') {
            isPositive = false;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length()) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numberFound = true;
                toReturn = (10) * toReturn + s.charAt(i) - '0';
            } else {
                if (numberFound) {
                    break;
                }
            }
            i++;
        }
        return isPositive ? toReturn : toReturn * -1;
    }
}
