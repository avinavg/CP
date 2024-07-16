package com.leetcode.io.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> values = new HashSet<>();
        while (n != 1) {
            if (values.contains(n)) {
                return false;
            }
            values.add(n);
            int newNumebr = 0;
            int number = n;
            while (number != 0) {
                int digit = number % 10;
                newNumebr += digit * digit;
                number = number / 10;
            }
            n = newNumebr;
        }
        return true;
    }
}
