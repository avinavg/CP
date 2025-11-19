package com.leetcode.io.microsoft;

public class validPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }


    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char first = validChar(s.charAt(start));
            char last = validChar(s.charAt(end));
            if (first == ' ') {
                start++;
                continue;
            }
            if (last == ' ') {
                end--;
                continue;
            }
            if (first != last) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static char validChar(char i) {
        if ((i >= 'a' && i <= 'z') || (i >= '0' && i <= '9')) {
            return i;
        } else if (i >= 'A' && i <= 'Z') {
            return (char) (i + 32);
        }
        return ' ';
    }


//    public static boolean isPalindrome(String s) {
//        String toCheck = toCheck(s);
//        return checkPalindrome(toCheck);
//    }
//
//    public static String toCheck(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            if((s.charAt(i)>=97 && s.charAt(i)<=122)||(s.charAt(i)>=48 && s.charAt(i)<=57)){
//                sb.append(s.charAt(i));
//            } else if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
//                sb.append((char)(s.charAt(i) + 32));
//            }
//        }
//        return sb.toString();
//
//    }
//
//    public static boolean checkPalindrome(String s) {
//        if (s.length() < 2) {
//            return true;
//        }
//        if (s.charAt(0) == s.charAt(s.length() - 1)) {
//            return checkPalindrome(s.substring(1, s.length() - 1));
//        } else {
//            return false;
//        }
//
//    }


}
