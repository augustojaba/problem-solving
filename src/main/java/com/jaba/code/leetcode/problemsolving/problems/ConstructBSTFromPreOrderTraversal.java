package com.jaba.code.leetcode.problemsolving.problems;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;

public class ConstructBSTFromPreOrderTraversal {

  public static TreeNode<Integer> bstFromPreorder(int[] preorder) {

    if (null == preorder || preorder.length == 0) {
      return null;
    }

    TreeNode<Integer> t = new TreeNode<>(preorder[0]);

    for (int i = 1; i < preorder.length; i++) {
      insert(t, preorder[i]);
    }

    return t;
  }

  private static TreeNode insert(TreeNode<Integer> t, Integer val) {

    if (null == t) {
      return new TreeNode<>(val);
    }

    if (val == t.val) {
      System.out.println("This key already exists.");
    }

    if (val < t.val) {
      t.left = insert(t.left, val);
    } else if (val > t.val) {
      t.right = insert(t.right, val);
    }

    return t;
  }

  public static void main(String[] args) {
    ConstructBSTFromPreOrderTraversal.bstFromPreorder(new int[] {8, 5, 1, 7, 10, 12}).print();
  }
}
