package com.leetcode.io.problems;

public class Leetcode443 {
    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }

    public static int compress(char[] a) {
        int charLength = 0;
        int k = 0;
        for (int i = 0; i <= a.length - 1; i++) {
            if (a[i] == a[k]) {
                charLength++;
            } else {
                if (charLength > 1) {
                    for (char ch : String.valueOf(charLength).toCharArray())
                        a[++k] = ch;
                }
                charLength = 1;
                a[++k] = a[i];
            }
        }
        if (charLength > 1) {
            for (char ch : String.valueOf(charLength).toCharArray())
                a[++k] = ch;
        }
        return k;

    }
}


// if (chars[i] == chars[i - 1]) {
//                charLength++;
//            } else {
//                chars[k] = chars[i];
//                if (charLength > 1 && charLength < 10) {
//                    chars[++k] = (char) charLength;
//                }
//                if (charLength > 10) {
//                    while (charLength != 0) {
//                        chars[++k] = (char) (charLength % 10);
//                        charLength = charLength / 10;
//
//                    }
//                }
//                charLength = 1;
//                k++;
//            }
//        }
//        return k;

