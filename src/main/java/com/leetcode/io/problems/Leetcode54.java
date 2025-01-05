package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3,}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int starti = 0;
        int startj = 0;
        int endi = matrix[0].length - 1;
        int endj = matrix.length - 1;
        List<Integer> toReturn = new ArrayList<>();

        while (starti <= endi && startj <= endj) {
            System.out.println("-->");
            for (int i = starti; i <=endi; i++) {
                toReturn.add(matrix[startj][i]);
                System.out.println(matrix[startj][i]);
            }
            System.out.println("|");
            for (int j = startj; j < endj; j++) {
                toReturn.add(matrix[j][endi]);
                System.out.println(matrix[j][endi]);
            }
            System.out.println("<--");
            for (int i = endi; i > starti; i--) {
                toReturn.add(matrix[endj][i]);

                System.out.println(matrix[endj][i]);
            }
            System.out.println("^");
            for (int j = endj; j > startj; j--) {
                toReturn.add(matrix[j][starti]);

                System.out.println(matrix[j][starti]);
            }
            startj++;
            starti++;
            endi--;
            endj--;
        }
        if (matrix.length == matrix[0].length && matrix.length % 2 != 0) {
            toReturn.add(matrix[matrix.length / 2][matrix.length / 2]);
            System.out.println(" " + matrix[matrix.length / 2][matrix.length / 2]);
        }
        return toReturn;
    }
}
