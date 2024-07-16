package com.leetcode.io.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int i = 0;
        int maxLength = 0;
        int len = 0;
        int start = 0;
        for (; i < s.length(); i++) {
            char currChar = s.charAt(i);
            Integer index = charIndexMap.get(currChar);
            if (index == null || index < start) {
                len++;
                charIndexMap.put(currChar, i);
                maxLength = Math.max(maxLength, len);
            } else {
                start = index + 1;
                charIndexMap.replace(currChar, i);
                len = i - start + 1;
            }
        }
        return maxLength;
    }
}
