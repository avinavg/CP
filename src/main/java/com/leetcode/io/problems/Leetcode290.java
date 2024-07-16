package com.leetcode.io.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abbf", "dog rabi cat dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length!=pattern.length()){
            return false;
        }
        int i = 0;
        Map<Character, String> charWordMap = new HashMap<>();
        for (String word : words) {
            if (charWordMap.get(pattern.charAt(i)) == null) {
                if (!charWordMap.containsValue(word)) {
                    charWordMap.put(pattern.charAt(i), word);
                } else {
                    return false;
                }
            } else if (!charWordMap.get(pattern.charAt(i)).equals(word)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
