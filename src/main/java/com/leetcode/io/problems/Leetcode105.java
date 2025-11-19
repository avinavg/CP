package com.leetcode.io.problems;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leetcode105 {

    private Map<Integer, Integer> inorderMap;
    private int preIndex = 0;

    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Convert inorder array to HashMap using Streams
        inorderMap = IntStream.range(0, inorder.length)
                .boxed()
                .collect(Collectors.toMap(i -> inorder[i], i -> i));

        return constructTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode constructTree(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        root.left = constructTree(preorder, inStart, inIndex - 1);
        root.right = constructTree(preorder, inIndex + 1, inEnd);

        return root;
    }

}
