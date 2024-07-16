package com.leetcode.io.leetcode;

import java.util.*;

public class Leetcode49 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> groupedAnagrams = groupAnagrams(strs);
        for (List<String> group : groupedAnagrams) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> codeStringsMap = new HashMap<>();
        for (String s : strs) {
            String key = generateHashCode(s.toCharArray());
            if (!codeStringsMap.containsKey(key)) {
                codeStringsMap.put(key, new ArrayList<>());
            }
            codeStringsMap.get(key).add(s);
        }
        return new ArrayList<>(codeStringsMap.values());
    }

    static String generateHashCode(char[] chars) {
        Arrays.sort(chars);
        return new String(chars);
    }
}
