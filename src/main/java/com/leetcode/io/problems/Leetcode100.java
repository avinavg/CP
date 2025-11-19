package com.leetcode.io.problems;

import com.leetcode.io.microsoft.trees.TreeNode;

public class Leetcode100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if ((p == null || q == null) || (p.val != q.val)) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
    }
}
