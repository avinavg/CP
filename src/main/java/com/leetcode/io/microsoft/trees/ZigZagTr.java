package com.leetcode.io.microsoft.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTr {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root1) {
        Queue<TreeNode> childQueue = new LinkedList<>();
        List<List<Integer>> childs = new ArrayList<>();
        boolean goRight = true;
        if (root1 != null) {
            childQueue.offer(root1);
        }
        while (!childQueue.isEmpty()) {
            int size = childQueue.size();
            LinkedList<Integer> levelNodes = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = childQueue.poll();
                if (goRight) {
                    levelNodes.addFirst(curr.val);
                } else {
                    levelNodes.addLast(curr.val);
                }
                if (curr.right != null) {
                    childQueue.offer(curr.right);
                }
                if (curr.left != null) {
                    childQueue.offer(curr.left);
                }
            }
            childs.add(levelNodes);
            goRight = !goRight;
        }
        return childs;
    }

}
//An array has n elements. If the array has less than 2 elements, then the array is returned witout any changes. If the array has more than two elements, then it is divided into two arrays, left and right. The left array contains the first half elements of the input array while the right array contains the second half of the elements. If n is odd, the left array takes the middle element. Next, the algorithm calls itself first with the left array and then with the right array. After that, the algorithm produces the sorted array, by merging the left and the right arrays into a single sorted array. In this challenge, keep a count for each of the elements in the input array. Initially, all counts are 0.
//Whenever an integer k from the right array is merged before at least one element from the left array, add 1 to the count. Find the maximum count value after the merge sort algorithm finishes.