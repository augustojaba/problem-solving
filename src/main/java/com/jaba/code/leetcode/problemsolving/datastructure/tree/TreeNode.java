package com.jaba.code.leetcode.problemsolving.datastructure.tree;

class TreeNode<T extends Comparable<?>> {

    T val;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
    }
}