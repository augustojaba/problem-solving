package com.jaba.code.leetcode.problemsolving.problems;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;

public class StringIsValidPathOnBT {

  public boolean dfs(final TreeNode<Integer> node, final int[] arr, final int pos) {

    if (null == node) {
      return arr.length == 0;
    }

    if ((node.left == null && node.right == null)
        && (node.val == arr[pos])
        && (node.val == arr[arr.length - 1])) {
      return true;
    }

    return pos + 1 < arr.length
        && (node.val == arr[pos]
            && (dfs(node.left, arr, pos + 1) || dfs(node.right, arr, pos + 1)));
  }

  public boolean isValidSequence(final TreeNode<Integer> root, final int[] arr) {
    return dfs(root, arr, 0);
  }

  public static void main(final String[] args) {
    final TreeNode<Integer> tree = new TreeNode(8);
    tree.left = new TreeNode(3);
    tree.left.left = new TreeNode(2);
    tree.left.left.left = new TreeNode(5);
    tree.left.left.right = new TreeNode(4);
    tree.left.right = new TreeNode(1);

    //    final TreeNode<Integer> tree = new TreeNode(0);
    //    tree.left = new TreeNode(1);
    //    tree.right = new TreeNode(0);
    //    tree.right.left = new TreeNode(0);
    //    tree.left.left = new TreeNode(0);
    //    tree.left.right = new TreeNode(1);
    //    tree.left.left.right = new TreeNode(0);
    //    tree.left.right.left = new TreeNode(0);

    tree.print();

    System.out.println(new StringIsValidPathOnBT().isValidSequence(tree, new int[] {0, 1, 1}));
  }
}
