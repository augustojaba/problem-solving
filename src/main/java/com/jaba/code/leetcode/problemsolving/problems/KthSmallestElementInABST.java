package com.jaba.code.leetcode.problemsolving.problems;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-20
 */
public class KthSmallestElementInABST {

  private int solution;
  private int k;

  public int kthSmallest(final TreeNode<Integer> root, final int k) {

    this.k = k;
    inOrder(root);
    return solution;
  }

  public void inOrder(final TreeNode<Integer> node) {

    if (node == null) {
      return;
    }

    inOrder(node.left);
    if (--k == 0) {
      solution = node.val;
    }
    inOrder(node.right);
  }
}
