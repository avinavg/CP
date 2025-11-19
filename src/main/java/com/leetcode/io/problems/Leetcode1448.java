package com.leetcode.io.problems;

public class Leetcode1448 {

    public static void main(String[] args) {

    }

    public int goodNodes(TreeNode root) {
        int count = 0;
        int max = 0;
        checkGoodNode(root, max);
        return count;
    }

    private int checkGoodNode(TreeNode root, int max) {
        int count = 0;
        if (root == null) {
            return 0;
        }
        if (root.val >= max) {
            count += 1;
        }
        max = Math.max(max, root.val);
        count += checkGoodNode(root.left, max);
        count += checkGoodNode(root.right, max);
        return count;
    }
}
