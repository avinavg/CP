package com.leetcode.io.leetcode;

public class BstPractice {
    public static void main(String[] args) {
        BinarySearchTree searchTree = new BinarySearchTree(9, null, null);
        searchTree.insert(searchTree, 4);
        searchTree.insert(searchTree, 20);
        searchTree.insert(searchTree, 1);
        searchTree.insert(searchTree, 6);
        searchTree.insert(searchTree, 15);
        searchTree.insert(searchTree, 97);
        BinarySearchTree obj = searchTree.lookup(98);


    }
}
