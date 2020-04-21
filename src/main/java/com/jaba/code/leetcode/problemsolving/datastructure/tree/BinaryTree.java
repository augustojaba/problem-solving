package com.jaba.code.leetcode.problemsolving.datastructure.tree;

public class BinaryTree {

  final TreeNode<Integer> root;

  BinaryTree(int val) {
      root = new TreeNode(val);
  }

  private static TreeNode search(TreeNode<Integer> t, Integer val) {

    if (null == t || null == val) {
      return null;
    }

    if (val == t.val) {
      return t;
    } else if (val < t.val) {
      return search(t.left, val);
    } else {
      return search(t.right, val);
    }
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

  private static void printTreePreOrder(TreeNode t) {
    if (t == null) {
      return;
    }

    System.out.println(t.val);
    printTreePreOrder(t.left);
    printTreePreOrder(t.right);
  }

  private static void printTreeInOrder(TreeNode t) {
    if (t == null) {
      return;
    }

    printTreePreOrder(t.left);
    System.out.println(t.val);
    printTreePreOrder(t.right);
  }

  private static int calculateHeight(TreeNode t) {
    if (t == null) {
      return 0;
    }

    int heightLeft = calculateHeight(t.left);
    int heightRight = calculateHeight(t.right);

    return Math.max(heightLeft, heightRight) + 1;
  }

  private static int diameter(TreeNode t) {
    if (t == null) {
      return 0;
    }

    int heightLeft = calculateHeight(t.left);
    int heightRight = calculateHeight(t.right);

    int diameterLeft = diameter(t.left);
    int diameterRight = diameter(t.right);

    return Math.max(heightLeft + heightRight + 1, Math.max(diameterLeft, diameterRight));
  }

  private static int diameterOptimized(TreeNode t, Height h) {

    Height lh = new Height();
    Height rh = new Height();

    if (t == null) {
      h.h = 0;
      return 0;
    }

    int diameterLeft = diameterOptimized(t.left, lh);
    int diameterRight = diameterOptimized(t.right, rh);

    h.h = Math.max(lh.h, rh.h) + 1;

    return Math.max(lh.h + rh.h + 1, Math.max(diameterLeft, diameterRight));
  }

  public static void main(String[] args) {
    BinaryTree tree = BinaryTreeInitializer.createBinaryTreeTest1();
    System.out.println(calculateHeight(tree.root));
    tree.root.print();
    System.out.println(diameter(tree.root));
    System.out.println(diameterOptimized(tree.root, new Height()));

    System.out.println("======= SEARCH =====");
    search(tree.root, 10).print();
    insert(tree.root, 13).print();
  }
}

class Height {
  int h;
}

class BinaryTreeInitializer {

  static BinaryTree createBinaryTreeTest1() {
    BinaryTree tree = new BinaryTree(8);
    tree.root.left = new TreeNode(3);
    tree.root.left.left = new TreeNode(1);
    tree.root.left.right = new TreeNode(6);
    tree.root.left.right.left = new TreeNode(4);
    tree.root.left.right.right = new TreeNode(7);
    tree.root.right = new TreeNode(10);
    tree.root.right.right = new TreeNode(14);
    tree.root.right.right.left = new TreeNode(13);
    return tree;
  }
}
