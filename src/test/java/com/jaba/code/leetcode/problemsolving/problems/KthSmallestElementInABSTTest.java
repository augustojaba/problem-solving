package com.jaba.code.leetcode.problemsolving.problems;

import com.jaba.code.leetcode.problemsolving.datastructure.tree.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-20
 */
public class KthSmallestElementInABSTTest {

  @Test
  public void kthSmallest() {
    final TreeNode<Integer> root = new TreeNode<>(3);
    root.left = new TreeNode<>(1);
    root.left.right = new TreeNode<>(2);
    root.right = new TreeNode<>(4);

    Assert.assertEquals(1, new KthSmallestElementInABST().kthSmallest(root, 1));
  }
}
