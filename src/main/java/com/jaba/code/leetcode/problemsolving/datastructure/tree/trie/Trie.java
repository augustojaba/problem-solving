package com.jaba.code.leetcode.problemsolving.datastructure.tree.trie;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-14
 */
public class Trie {

  /** Alphabet: abcdefghijklmnopqrstuvwxyz */
  public static final int ALPHABET = 26;

  private final TrieNode root;

  public Trie() {
    root = new TrieNode(ALPHABET);
  }

  public TrieNode getRoot() {
    return root;
  }

  /** Inserts a word into the trie. */
  public void insert(final String word) {

    if (word == null || word.isEmpty()) {
      return;
    }

    TrieNode pointer = root;

    for (int i = 0; i < word.length(); i++) {
      if (pointer.children[word.charAt(i) - 'a'] == null) {
        pointer.children[word.charAt(i) - 'a'] = new TrieNode(ALPHABET);
      }
      pointer = pointer.children[word.charAt(i) - 'a'];
    }

    pointer.isEndOfWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(final String word) {

    if (word == null || word.isEmpty()) {
      return false;
    }

    TrieNode pointer = root;

    for (int i = 0; i < word.length(); i++) {
      if (pointer.children[word.charAt(i) - 'a'] != null) {
        pointer = pointer.children[word.charAt(i) - 'a'];
      } else {
        return false;
      }
    }
    return pointer.isEndOfWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(final String prefix) {
    if (prefix == null || prefix.isEmpty()) {
      return false;
    }

    TrieNode pointer = root;

    for (int i = 0; i < prefix.length(); i++) {
      if (pointer.children[prefix.charAt(i) - 'a'] != null) {
        pointer = pointer.children[prefix.charAt(i) - 'a'];
      } else {
        return false;
      }
    }
    return true;
  }
}
