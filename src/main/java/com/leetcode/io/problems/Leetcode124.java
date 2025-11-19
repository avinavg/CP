package com.leetcode.io.problems;

public class Leetcode124 {
    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

    }

    public int maxPathSum(TreeNode root) {

        getSum(root);
        return maxSum;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(0, getSum(root.left));
        int right = Math.max(0, getSum(root.right));

        int sum = root.val + left + right;
        maxSum = Math.max(maxSum, sum);

        return root.val + Math.max(left, right);

    }


}
