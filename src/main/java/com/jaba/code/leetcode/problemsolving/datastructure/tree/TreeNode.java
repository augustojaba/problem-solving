package com.jaba.code.leetcode.problemsolving.datastructure.tree;

public class TreeNode<T extends Comparable<?>> {

  public T val;
  public TreeNode<T> left;
  public TreeNode<T> right;

  public TreeNode(final T val) {
    this.val = val;
  }

  public void print() {
    BinaryTreePrinter.printNode(this);
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + val + '}';
  }
}
