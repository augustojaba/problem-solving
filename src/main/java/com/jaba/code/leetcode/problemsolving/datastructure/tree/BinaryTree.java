package com.jaba.code.leetcode.problemsolving.datastructure.tree;

public class BinaryTree {

    final TreeNode<Integer> root;

    BinaryTree(int val) {
        root = new TreeNode(val);
    }

    private static void printTreePreOrder(TreeNode t) {
        if (t == null) return;

        System.out.println(t.val);
        printTreePreOrder(t.left);
        printTreePreOrder(t.right);
    }

    private static void printTreeInOrder(TreeNode t) {
        if (t == null) return;

        printTreePreOrder(t.left);
        System.out.println(t.val);
        printTreePreOrder(t.right);
    }

    private static int calculateHeight(TreeNode t) {
        if (t == null) return 0;

        int heightLeft = calculateHeight(t.left);
        int heightRight = calculateHeight(t.right);

        return Math.max(heightLeft, heightRight) + 1;
    }

    private static int diameter(TreeNode t) {
        if (t == null) return 0;

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
        BinaryTreePrinter.printNode(tree.root);
        System.out.println(diameter(tree.root));
        System.out.println(diameterOptimized(tree.root, new Height()));
    }
}

class Height {
    int h;
}

class BinaryTreeInitializer {

    static BinaryTree createBinaryTreeTest1() {
        BinaryTree tree = new BinaryTree(2);
        tree.root.left = new TreeNode(3);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(7);
        tree.root.left.right.left = new TreeNode(12);
        tree.root.left.right.left.right = new TreeNode(4);
        tree.root.right = new TreeNode(1);
        return tree;
    }
}


