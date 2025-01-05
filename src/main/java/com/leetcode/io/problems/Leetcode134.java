package com.leetcode.io.problems;

public class Leetcode134 {
    public static void main(String[] args) {

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int bp = -1;
        int gasSum = 0;
        int costSum = 0;
        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
            if (gas[i] > cost[i]) {
                bp = i;
            }
        }
        if (costSum > gasSum) {
            return -1;
        }
        return bp;

    }
}
