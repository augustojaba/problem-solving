package com.jaba.code.leetcode.problemsolving.java8;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;

public class CousinsinBinaryTree {

  private TreeNode rootX;
  private int hX;
  private TreeNode rootY;
  private int hY;

  public boolean isCousins(final TreeNode<Integer> root, final int x, final int y) {
    rootX = null;
    rootY = null;

    final boolean foundX = findNode(root, null, x, 0);
    final boolean foundY = findNodeY(root, null, y, 0);

    if (foundX && foundY && hX == hY && rootX != rootY) {
      return true;
    }

    return false;
  }

  public boolean findNode(
      final TreeNode<Integer> root, final TreeNode<Integer> parent, final int x, int h) {

    if (null == root) {
      return false;
    }

    if (x == root.val) {
      rootX = parent;
      hX = h;
      return true;
    } else {
      h++;
      return findNode(root.left, root, x, h) || findNode(root.right, root, x, h);
    }
  }

  public boolean findNodeY(
      final TreeNode<Integer> root, final TreeNode<Integer> parent, final int y, int h) {

    if (null == root) {
      return false;
    }

    if (y == root.val) {
      rootY = parent;
      hY = h;
      return true;
    } else {
      h++;
      return findNodeY(root.left, root, y, h) || findNodeY(root.right, root, y, h);
    }
  }

  public static void main(final String[] args) {
    final TreeNode<Integer> tree = new TreeNode(1);
    tree.left = new TreeNode(2);
    tree.right = new TreeNode(3);
    tree.left.right = new TreeNode(4);
    tree.right.right = new TreeNode(5);

    System.out.println(new CousinsinBinaryTree().isCousins(tree, 4, 5));
  }
}
