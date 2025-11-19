package com.leetcode.io.microsoft;

import java.util.*;

public class Meesho {
    public static int countVerticalPaths(List<Integer> cost, int edgeNodes, List<Integer> edgeFrom, List<Integer> edgeTo, int k) {
        int numNodes = cost.size();
        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < edgeFrom.size(); i++) {


            int from = edgeFrom.get(i) - 1;
            int to = edgeTo.get(i) - 1;

            tree.get(from).add(to);
            tree.get(to).add(from);

        }

        int[] count = new int[1];

        iterateNodes(0, -1, 0,
                new HashMap<>(), cost, tree, k, count);


        return count[0];
    }

    private static void iterateNodes(int node, int parent, int currentSum, Map<Integer, Integer> prefixCount,
                                     List<Integer> cost, List<List<Integer>> tree, int k, int[] count) {
        currentSum += cost.get(node);

        if (currentSum % k == 0) {
            count[0]++;
        }

        // if (prefixes.containsKey(curr)) {
        //      prefixes.put(curr, prefixes.get(curr) + 1);
        //    } else {
        //      prefixes.put(curr, 1);
        //    }

        int modValue = (currentSum % k + k) % k;
        count[0] += prefixCount.getOrDefault(modValue, 0);

        prefixCount.put(modValue, prefixCount.getOrDefault(modValue, 0) + 1);

        for (int child : tree.get(node)) {
            if (child != parent) {
                iterateNodes(child, node, currentSum, prefixCount, cost, tree, k, count);
            }
        }

        prefixCount.put(modValue, prefixCount.get(modValue) - 1);
    }

    public static void main(String[] args) {
        Meesho test = new Meesho();
        test.test1();
        test.test2();
        test.test3();
    }

    public void test1() {
        List<Integer> cost = Arrays.asList(1, 1, 1, 1);
        List<Integer> from = Arrays.asList(1, 1, 4);
        List<Integer> to = Arrays.asList(2, 4, 3);
        int n = countVerticalPaths(cost, 3, from, to, 2);
        System.out.printf("Number of paths: %d\n", n);
    }

    public void test2() {
        List<Integer> cost = Arrays.asList(1, 2, 2, 1, 2);
        List<Integer> from = Arrays.asList(1, 1, 2, 2);
        List<Integer> to = Arrays.asList(2, 4, 3, 5);
        int n = countVerticalPaths(cost, 4, from, to, 2);
        System.out.printf("Number of paths: %d\n", n);
    }

    public void test3() {
        /*
                    1
                  /
                2
              /
            2
        */
        List<Integer> cost = Arrays.asList(1, 2, 2);
        List<Integer> from = Arrays.asList(1, 2);
        List<Integer> to = Arrays.asList(2, 3);
        int n = countVerticalPaths(cost, 2, from, to, 2);
        System.out.printf("Number of paths: %d\n", n);
    }
}