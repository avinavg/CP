package com.leetcode.io.problems;

public class Leetcode733 {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] a, int sr, int sc, int color) {
        if (a[sr][sc] != color) {
            colorNeighbors(a, sr, sc, a[sr][sc], color);
        }
        return a;
    }


    void colorNeighbors(int[][] a, int sr, int sc, int color) {
//        int north = sr == 0 ? 0 : sr - 1;
//
//        int south = (sr == a.length - 1) ? a.length - 1 : sr + 1;
//        int west = (sc == 0) ? 0 : sc - 1;
//        int east = (sc == a[0].length - 1) ? a[0].length - 1 : sc + 1;


        int north = (sr - 1 < 0) ? -1 : sr - 1;
        int south = (sr + 1 >= a.length) ? -1 : sr + 1;
        int west = (sc - 1 < 0) ? -1 : sc - 1;
        int east = (sc + 1 >= a[0].length) ? -1 : sc + 1;

//        if (north <= -1 || south <= -1 || west <= -1 || east <= -1) {
//            return;
//        }

        if (north != -1 && a[north][sc] == a[sr][sc]) {
            a[north][sc] = color;
            floodFill(a, north, sc, color);

        }

        if (south != -1 && a[south][sc] == a[sr][sc]) {
            a[south][sc] = color;
            floodFill(a, south, sc, color);

        }
        if (west != -1 && a[sr][west] == a[sr][sc]) {
            a[sr][west] = color;
            floodFill(a, sr, west, color);

        }
        if (east != -1 && a[sr][east] == a[sr][sc]) {
            a[sr][east] = color;
            floodFill(a, sr, east, color);

        }
    }

    void colorNeighbors(int[][] a, int sr, int sc, int originalColor, int color) {
        int north = (sr - 1 < 0) ? -1 : sr - 1;
        int south = (sr + 1 >= a.length) ? -1 : sr + 1;
        int west = (sc - 1 < 0) ? -1 : sc - 1;
        int east = (sc + 1 >= a[0].length) ? -1 : sc + 1;

        if (a[sr][sc] != originalColor) return; // Check if the cell should be colored

        a[sr][sc] = color;

        if (north != -1 && a[north][sc] == originalColor) colorNeighbors(a, north, sc, originalColor, color);
        if (south != -1 && a[south][sc] == originalColor) colorNeighbors(a, south, sc, originalColor, color);
        if (west != -1 && a[sr][west] == originalColor) colorNeighbors(a, sr, west, originalColor, color);
        if (east != -1 && a[sr][east] == originalColor) colorNeighbors(a, sr, east, originalColor, color);
    }
}

