package com.jaba.code.leetcode.problemsolving.datastructure.tree.trie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-14
 */
public class TrieTest {

  private Trie trie;

  @Before
  public void initializeObject() {
    trie = new Trie();
  }

  @Test
  public void insert_Test_RegularWord() {
    trie.insert("test");
    TrieNode pointer = trie.getRoot().children[19];
    assertFalse(pointer == null);
    pointer = pointer.children[4];
    assertFalse(pointer == null);
    pointer = pointer.children[18];
    assertFalse(pointer == null);
    pointer = pointer.children[19];
    assertFalse(pointer == null);
    assertTrue(pointer.isEndOfWord);
  }

  @Test
  public void insert_Test_Null() {
    trie.insert(null);

    boolean hasNull = false;
    for (int i = 0; i < trie.getRoot().children.length; i++) {
      if (null != trie.getRoot().children[i]) {
        hasNull = true;
      }
    }

    assertFalse(hasNull);
    assertFalse(trie.getRoot().isEndOfWord);
  }

  @Test
  public void insert_Test_Empty() {
    trie.insert("");

    boolean hasNull = false;
    for (int i = 0; i < trie.getRoot().children.length; i++) {
      if (null != trie.getRoot().children[i]) {
        hasNull = true;
      }
    }

    assertFalse(hasNull);
    assertFalse(trie.getRoot().isEndOfWord);
  }

  @Test
  public void search_Test_RegularWord() {
    trie.insert("test");
    assertTrue(trie.search("test"));
  }

  @Test
  public void search_Test_PartWord() {
    trie.insert("test");
    assertFalse(trie.search("tes"));
  }

  @Test
  public void search_Test_NonExistent() {
    trie.insert("test");
    assertFalse(trie.search("abcde"));
  }

  @Test
  public void search_Test_Null() {
    trie.insert("test");
    assertFalse(trie.search(null));
  }

  @Test
  public void search_Test_Empty() {
    trie.insert("test");
    assertFalse(trie.search(""));
  }

  @Test
  public void startsWith() {}

  @Test
  public void startsWith_Test_RegularWord() {
    trie.insert("test");
    assertTrue(trie.startsWith("test"));
  }

  @Test
  public void startsWith_Test_PartWord() {
    trie.insert("test");
    assertTrue(trie.startsWith("te"));
  }

  @Test
  public void startsWith_Test_NonExistent() {
    trie.insert("test");
    assertFalse(trie.startsWith("ab"));
  }

  @Test
  public void startsWith_Test_Null() {
    trie.insert("test");
    assertFalse(trie.startsWith(null));
  }

  @Test
  public void startsWith_Test_Empty() {
    trie.insert("test");
    assertFalse(trie.startsWith(""));
  }
}
