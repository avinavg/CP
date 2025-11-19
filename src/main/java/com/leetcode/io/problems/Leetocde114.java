package com.leetcode.io.problems;

public class Leetocde114 {
    public static void main(String[] args) {

    }

    //traverse to leftmost node
    //assign leftto uss tree k right
    //assign curr tree ka right to left ka right
//TODO
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // Flatten left and right subtrees
        flatten(root.left);
        flatten(root.right);

        // If left subtree exists, move it to the right
        if (root.left != null) {
            TreeNode temp = root.right;

            root.right = root.left;
            root.left = null;

            // Find the rightmost node of the new right subtree
            TreeNode curr = root.right;
            while (curr.right != null) {
                curr = curr.right;
            }

            // Attach the original right subtree
            curr.right = temp;
        }
    }
}
