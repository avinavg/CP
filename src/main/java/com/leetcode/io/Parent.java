package com.leetcode.io;

// interface Bird {
//     void fly();
//
// }
//
// class Pigeon implements Bird{
//
//     @Override
//     public void fly() {
//         System.out.println("Bird is flying");
//     }
//
//     public void fly(String s){
//         System.out.println(s);
//     }
//
//     public void fly(Integer s){
//         System.out.println(s);
//     }
//
//
//
// }
//Find the first non-repeating character in a string.

import java.util.HashMap;
import java.util.Map;

class Parent {
    public static void main(String[] args) {
        System.out.println(findNonRepeatingChar("aabbcccfggh"));
    }

    private static char findNonRepeatingChar(String s) {

        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (charFreqMap.get(ch) == null) {
                charFreqMap.put(ch, 1);
            } else {
                int value = charFreqMap.get(ch) + 1;
                charFreqMap.put(ch, value);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charFreqMap.get(ch) == 1) {
                return ch;

            }
        }
        return '0';
    }

}

