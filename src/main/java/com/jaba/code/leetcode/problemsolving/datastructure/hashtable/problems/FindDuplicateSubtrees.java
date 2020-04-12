package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
  }
}

class Solution1 {

  private Map<String, Integer> map;
  private List<TreeNode> answer;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    map = new HashMap<>();
    answer = new ArrayList<>();
    lookup(root);

    return answer;
  }

  private String lookup(TreeNode subTreeRoot) {

    if (subTreeRoot == null) {
      return "#";
    }

    String key =
        new StringBuffer()
            .append(subTreeRoot.val)
            .append(lookup(subTreeRoot.left))
            .append(lookup(subTreeRoot.right))
            .toString();

    map.put(key, map.getOrDefault(key, 0) + 1);

    if (map.get(key) == 2) {
      answer.add(subTreeRoot);
    }

    return key;
  }
}

class Solution2 {

  private int index;
  private Map<Integer, Integer> count;
  private Map<String, Integer> trees;
  private List<TreeNode> answer;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    index = 1;
    trees = new HashMap<>();
    count = new HashMap<>();
    answer = new ArrayList<>();
    lookup(root);

    return answer;
  }

  private String lookup(TreeNode subTreeRoot) {

    if (subTreeRoot == null) {
      return "#";
    }

    String key =
        new StringBuffer()
            .append(subTreeRoot.val)
            .append(lookup(subTreeRoot.left))
            .append(lookup(subTreeRoot.right))
            .toString();

    int uuid = trees.computeIfAbsent(key, x -> index++);

    count.put(uuid, count.getOrDefault(uuid, 0) + 1);

    if (count.get(uuid) == 2) {
      answer.add(subTreeRoot);
    }

    return key;
  }
}

public class FindDuplicateSubtrees {

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(2);
    TreeNode t6 = new TreeNode(4);
    TreeNode t7 = new TreeNode(4);

    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t3.left = t5;
    t3.right = t6;
    t5.left = t7;

    System.out.println(new Solution2().findDuplicateSubtrees(t1));
  }
}
