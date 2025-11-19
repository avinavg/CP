package com.leetcode.io.problems;

public class Leetcode129 {
    int sum = 0;

    public static void main(String[] args) {

    }

    public int sumNumbers(TreeNode root) {
        getDigits(root, 0);
        return sum;
    }

    private void getDigits(TreeNode root, int digit) {
        if (root == null) {
            return;
        }
        digit = digit * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum = sum + digit;
        }
        getDigits(root.left, digit);
        getDigits(root.right, digit);
    }
}

