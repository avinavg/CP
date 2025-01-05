package com.leetcode.io.problems;

import java.util.HashMap;
import java.util.Map;

public class Leetcode36 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] a) {
        int right = 3;
        int left = 0;
        int top = 0;
        int bottom = 3;
        Map<Character, Boolean> characterBooleanMap = new HashMap<>();
        Map<Character, Boolean> characterBooleanMap2 = new HashMap<>();
//        System.out.println("-----------Check one------------");

        boolean toReturn = true;
        do {
            for (int i = top; i < bottom; i++) {
                for (int j = left; j < right; j++) {
//                    System.out.println("(" + i + "," + j + ")");
                    if (a[i][j] != '.') {
                        if (characterBooleanMap.get(a[i][j]) == null) {
                            characterBooleanMap.put(a[i][j], true);
                        } else {
                            return false;
                        }
                    }
                }
            }
            left = left + 3;
            right = right + 3;
            characterBooleanMap.clear();
            if (left == 9) {
                top = top + 3;
                bottom = top + 3;
                right = 3;
                left = 0;
            }
        } while (top != 9);
//        System.out.println("-----------Check two------------");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
//                System.out.println("(" + i + "," + j + ") = " + a[i][j]);
//                System.out.println("(" + j + "," + i + ") = " + a[j][i]);

                if (a[i][j] != '.') {
                    if (characterBooleanMap.get(a[i][j]) == null) {
                        characterBooleanMap.put(a[i][j], true);
                    } else {
//                        System.out.println("here1");
                        return false;
                    }
                }
                if (a[j][i] != '.') {
                    if (characterBooleanMap2.get(a[j][i]) == null) {
                        characterBooleanMap2.put(a[j][i], true);
                    } else {
//                        System.out.println("here2");
                        return false;
                    }
                }
            }
//            System.out.println("Clearing maps");
            characterBooleanMap.clear();
            characterBooleanMap2.clear();
        }
        return true;
    }

}

