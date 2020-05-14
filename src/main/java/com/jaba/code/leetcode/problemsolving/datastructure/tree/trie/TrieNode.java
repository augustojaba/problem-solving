package com.jaba.code.leetcode.problemsolving.datastructure.tree.trie;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-14
 */
public class TrieNode {

  TrieNode[] children;
  boolean isEndOfWord;

  public TrieNode(final int alphabetSize) {
    children = new TrieNode[alphabetSize];
  }
}
