package com.jaba.code.leetcode.problemsolving.datastructure.tree;

public class TreeNode<T extends Comparable<?>> {

  public T val;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(T val) {
    this.val = val;
  }

  public void print() {
    BinaryTreePrinter.printNode(this);
  }
}
