package com.leetcode.io.problems;

public class BinarySearchTree {
    public int value;
    public BinarySearchTree right;
    public BinarySearchTree left;

    public BinarySearchTree(int value, BinarySearchTree right, BinarySearchTree left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    void insert(BinarySearchTree root, int value) {
        if (root == null) {
            new BinarySearchTree(value, null, null);
        }
        if (value > root.value) {
            if (root.right != null) {
                insert(root.right, value);
            } else {
                root.right = new BinarySearchTree(value, null, null);
            }
        } else {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new BinarySearchTree(value, null, null);
            }
        }
    }

    BinarySearchTree lookup(int value) {
        if (this.value == value) {
            return this;
        }
        if (this.right == null && this.left == null) {
            return null;
        }
        if (this.value > value) {
            return this.left.lookup(value);
        } else {
            return this.right.lookup(value);
        }
    }

//    BinarySearchTree remove(BinarySearchTree node){
//        if(this.value == node.value){
//            BinarySearchTree right = this.right;
//            BinarySearchTree migiLeft = right.left;
//
//        }
//
//    }
}
