package com.leetcode.io.problems;

import java.util.Objects;

public class Leetcode101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkSymmetry(root.left, root.right);

    }

    private boolean checkSymmetry(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if ((left == null || right == null) || (!Objects.equals(left.val, right.val))) {
            return false;
        }
        return checkSymmetry(left.left, right.right) && checkSymmetry(left.right, right.left);

    }

}
