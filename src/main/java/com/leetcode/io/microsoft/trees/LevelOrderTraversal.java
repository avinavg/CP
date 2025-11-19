package com.leetcode.io.microsoft.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(3);
        System.out.println(levelOrder(root1)); // true

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root)); // true
    }


    private static List<List<Integer>> levelOrder(TreeNode root1) {
        Queue<TreeNode> childQueue = new LinkedList<>();
        List<List<Integer>> childs = new ArrayList<>();
        if (root1 != null) {
            childQueue.offer(root1);
        }
        while (!childQueue.isEmpty()) {
            int size = childQueue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = childQueue.poll();
                levelNodes.add(node.val);
                if (node.left != null) {
                    childQueue.offer(node.left);
                }
                if (node.right != null) {
                    childQueue.offer(node.right);
                }
            }
            childs.add(levelNodes);
        }
        return childs;
    }


    // if (node.left!=null){
    //                childQueue.offer(node.left);
    //            }
    //            if (node.right!=null){
    //                childQueue.offer(node.right);
    //            }
//    private static List<List<Integer>> levelOrder(TreeNode root1) {
//        Queue<TreeNode> childQueue = new LinkedList<>();
//        List<List<Integer>> childs = new ArrayList<>();
//        if (root1 != null) {
//            childQueue.offer(root1);
//            List<Integer> firstList = new ArrayList<>();
//            firstList.add(root1.val);
//            childs.add(firstList);
//        }
//        while (childQueue.peek() != null) {
//            List<Integer> childpods = addChilds(childQueue);
//            if (!childpods.isEmpty()) {
//                childs.add(childpods);
//            }
//        }
//        return childs;
//    }
//
//    private static List<Integer> addChilds(Queue<TreeNode> childQueue) {
//        TreeNode currNode = childQueue.poll();
//        List<Integer> toReturn = new ArrayList<>();
//        if (currNode.left != null) {
//            childQueue.offer(currNode.left);
//            toReturn.add(currNode.left.val);
//        }
//        if (currNode.right != null) {
//            childQueue.offer(currNode.right);
//            toReturn.add(currNode.right.val);
//        }
//        return toReturn;
//    }
}
