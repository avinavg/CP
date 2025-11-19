package com.leetcode.io.problems;

import java.util.Stack;

public class Leetcode173 {

    public static void main(String[] args) {

    }

    class BSTIterator {

        TreeNode currNode = null;
        Stack<TreeNode> numbersStack = new Stack<>();

        public BSTIterator(TreeNode root) {
            this.currNode = root;
            addtoStack(root);
        }

        private void addtoStack(TreeNode root) {
            if (root == null) {
                return;
            }
            addtoStack(root.right);
            numbersStack.push(root);
            addtoStack(root.left);
        }

        public int next() {
            TreeNode next = numbersStack.pop();
            return next.val;
        }

        public boolean hasNext() {
            return !numbersStack.isEmpty();

        }
    }
}
