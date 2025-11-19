package com.leetcode.io.microsoft;

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


    public static List<String> letterCombinations2(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<String>();
        if (digits.length() == 0)
            return result;
        helper(digits, dict, result, 0, new StringBuilder());
        return result;
    }

    public static void helper(String digits, String[] dict, List<String> result, int start, StringBuilder sb) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String digit = digits.substring(start, start + 1);
        for (char c : dict[Integer.parseInt(digit)].toCharArray()) {
            sb.append(c);
            helper(digits, dict, result, start + 1, sb);
            sb.setLength(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(letterCombinations2("23"));

    }
}
