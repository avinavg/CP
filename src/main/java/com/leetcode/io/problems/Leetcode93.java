package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.List;

public class Leetcode93 {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 parts and used all characters, it's a valid IP
        if (current.size() == 4 && start == s.length()) {
            result.add(String.join(".", current));
            return;
        }

        // If we have 4 parts but haven't used all characters, it's invalid
        if (current.size() >= 4) return;

        // Try segments of length 1 to 3
        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break; // Out of bounds check

            String segment = s.substring(start, start + len);

            if (isValid(segment)) {
                current.add(segment); // Choose
                backtrack(s, start + len, current, result); // Explore
                current.remove(current.size() - 1); // Unchoose (Backtrack)
            }
        }
    }

    private static boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false; // No leading zeros
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }

    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s)); // Output: ["255.255.11.135", "255.255.111.35"]
    }
}
