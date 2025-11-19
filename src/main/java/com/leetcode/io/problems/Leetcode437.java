package com.leetcode.io.problems;

public class Leetcode437 {

    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = countPaths(root, targetSum);

        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);

        return count;
    }

    private int countPaths(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (targetSum == root.val) {
            count++;
        }
        count += countPaths(root.left, targetSum - root.val);
        count += countPaths(root.right, targetSum - root.val);

        return count;
    }
}
