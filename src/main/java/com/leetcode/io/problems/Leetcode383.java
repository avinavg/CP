package com.leetcode.io.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "ab"));
    }

    static boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        for (char c : magazine.toCharArray()) {
            charCount[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (charCount[c - 'a'] <= 0) {
                return false;
            }
            charCount[c - 'a']--;
        }
        return true;
    }

    static boolean canConstructUsingMaps(String ransomNote, String magazine) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            charFreqMap.put(magazine.charAt(i), charFreqMap.getOrDefault(magazine.charAt(i), 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char x = ransomNote.charAt(i);
            if (charFreqMap.get(x) == null || charFreqMap.get(x) <= 0) {
                return false;
            } else {
                charFreqMap.replace(x, charFreqMap.get(x) - 1);
            }
        }
        return true;
    }
}
