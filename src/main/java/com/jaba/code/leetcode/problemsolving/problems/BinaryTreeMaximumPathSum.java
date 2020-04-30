package com.jaba.code.leetcode.problemsolving.problems;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;

public class BinaryTreeMaximumPathSum {

  public int maxPathSum(final TreeNode<Integer> root) {
    final MutableInteger maxPath = new MutableInteger(Integer.MIN_VALUE);
    pathSum(root, maxPath);
    return maxPath.value;
  }

  public int pathSum(final TreeNode<Integer> node, final MutableInteger maxPath) {
    if (null == node) {
      return 0;
    }

    final int left = Math.max(0, pathSum(node.left, maxPath));
    final int right = Math.max(0, pathSum(node.right, maxPath));

    maxPath.value = Math.max(maxPath.value, left + right + node.val);
    return Math.max(left, right) + node.val;
  }

  public static void main(final String[] args) {
    final TreeNode<Integer> tree = new TreeNode(-10);
    tree.left = new TreeNode(9);
    tree.right = new TreeNode(20);
    tree.right.right = new TreeNode(7);
    tree.right.left = new TreeNode(15);

    System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(tree));
  }

  class MutableInteger {
    int value;

    public MutableInteger(final int value) {
      this.value = value;
    }
  }
}
