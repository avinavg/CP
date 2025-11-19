package com.leetcode.io.problems;


import java.util.*;

public class Leetcode17 {

    private static final Map<Character, List<String>> numberCharList = new HashMap<>();

    static {
        numberCharList.put('2', Arrays.asList("a", "b", "c"));
        numberCharList.put('3', Arrays.asList("d", "e", "f"));
        numberCharList.put('4', Arrays.asList("g", "h", "i"));
        numberCharList.put('5', Arrays.asList("j", "k", "l"));
        numberCharList.put('6', Arrays.asList("m", "n", "o"));
        numberCharList.put('7', Arrays.asList("p", "q", "r", "s"));
        numberCharList.put('8', Arrays.asList("t", "u", "v"));
        numberCharList.put('9', Arrays.asList("w", "x", "y", "z"));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> toReturn = new ArrayList<>();
        int iter = 0;
        if (digits.length() > 0) {
            toReturn.addAll(numberCharList.get(digits.charAt(iter++)));
        }
        while (iter != digits.length()) {
            getCombinations(toReturn, digits.charAt(iter));
            iter++;
        }
        return toReturn;
    }

    private static void getCombinations(List<String> toReturn, char digit) {
        List<String> newStrings = new ArrayList<>();
        for (String chars : toReturn) {
            for (String alphabet : numberCharList.get(digit)) {
                newStrings.add(chars + alphabet);
            }
        }
        toReturn.clear();
        toReturn.addAll(newStrings);
    }


}
