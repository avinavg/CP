package com.leetcode.io.problems;

public class Leetcode872 {
    public static void main(String[] args) {

    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder root1String = new StringBuilder();
        StringBuilder root2String = new StringBuilder();
        getLeafString(root1, root1String);
        getLeafString(root2, root2String);
        return root1String.equals(root2String);
    }

    private void getLeafString(TreeNode root, StringBuilder root1String) {
        if (root.left == null && root.right == null) {
            root1String.append(root.val).append(",");
            return;
        }
        if (root.left != null) getLeafString(root.left, root1String);
        if (root.right != null) getLeafString(root.right, root1String);
    }

}
