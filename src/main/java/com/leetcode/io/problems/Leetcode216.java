package com.leetcode.io.problems;

import java.util.ArrayList;
import java.util.List;

public class Leetcode216 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {


        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1, k, n, new ArrayList<>(), result);
        return result;

    }

    private void findCombinations(int start, int k, int target, List<Integer> current, List<List<Integer>> result) {

        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (target < i) break;
            current.add(i);
            findCombinations(i + 1, k - i, target - i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
