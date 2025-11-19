package com.leetcode.io.problems;


public class Leetcode226 {


    public static void main(String[] args) {
//        [4,2,7,1,3,6,9]

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(7);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(9);
        Leetcode226 obj = new Leetcode226();
        TreeNode newNode = obj.invertTree(node);
        System.out.println(newNode);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        buildTree(root, node);
        return node;

    }

    private void buildTree(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        if (root.right != null)
            node.left = new TreeNode(root.right.val);
        if (root.left != null)
            node.right = new TreeNode(root.left.val);
        buildTree(root.left, node.right);
        buildTree(root.right, node.left);
    }
}
