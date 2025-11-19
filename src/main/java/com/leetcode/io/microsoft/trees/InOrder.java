package com.leetcode.io.microsoft.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrder {

    static List<Integer> arrays = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        inorderTraversal(root1); // true
        System.out.println(arrays);

        arrays.clear();
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(4);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(6);
        inorderTraversal(root2); // fal
        System.out.println(arrays);


    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arrays = new ArrayList();
        inorderTraversalHelper(root, arrays);
        return arrays;
    }

    public static void inorderTraversalHelper(TreeNode root, List<Integer> arrays) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, arrays);
        arrays.add(root.val);
        inorderTraversalHelper(root.right, arrays);
    }
}
