package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.Map;

public class BstPractice {
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree(9, null, null);
        searchTree.insert(searchTree, 4);
        searchTree.insert(searchTree, 20);
        searchTree.insert(searchTree, 1);
        searchTree.insert(searchTree, 6);
        searchTree.insert(searchTree, 15);
        searchTree.insert(searchTree, 97);
        BinarySearchTree obj = searchTree.lookup(98);


    }

    public static class Leetcode290 {
        public static void main(String[] args) {
            System.out.println(wordPatternRevise("abbf", "dog cat cat dog"));
        }

        public static boolean wordPattern(String pattern, String s) {
            String[] words = s.split(" ");
            if (words.length != pattern.length()) {
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

        public static boolean wordPatternRevise(String pattern, String s) {

            Map<Character, String> stringMap = new HashMap<>();
            Map<String, Character> mapString = new HashMap<>();


            String[] words = s.split(" ");
            for (int i = 0; i < pattern.length(); i++) {
                int finalI = i;
                stringMap.computeIfAbsent(pattern.charAt(i), k -> words[finalI]);
                mapString.computeIfAbsent(words[i], k -> (pattern.charAt(finalI)));
                if (!stringMap.get(pattern.charAt(i)).equals(words[i]) ||
                        !mapString.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                }

            }
            return true;
        }
    }

    public static class LeetCode392 {
        public static void main(String[] args) {
            System.out.println(isSubsequenceRevise("aaaaaa", "bbaaaa"));

        }

        static boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            if (t.length() < s.length()) {
                return false;
            }
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(0) == t.charAt(i)) {
                    return isSubsequence(s.substring(1), t.substring(i + 1));
                }
            }
            return false;
        }

        static boolean isSubsequenceRevise(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            int iterForS = 0;
            int iterForT = 0;
            while (iterForS < s.length() && iterForT < t.length()) {
                if (s.charAt(iterForS) == t.charAt(iterForT)) {
                    iterForS++;
                }
                iterForT++;
            }
            return iterForS > s.length();
        }
    }
}
