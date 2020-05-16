package com.jaba.code.leetcode.sandbox;

import com.jaba.code.leetcode.problemsolving.datastructure.hashtable.MyHashSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MyHashTest {

  @Test
  public void testMyList() {
    final MyHashSet hash = new MyHashSet();
    hash.add(0);
    hash.add(1000000);
    hash.add(1);
    hash.add(1);
    hash.add(2);
    hash.add(47);

    Assert.assertTrue(hash.contains(0));
    Assert.assertTrue(hash.contains(1));
    Assert.assertTrue(hash.contains(2));
    Assert.assertTrue(hash.contains(47));
    Assert.assertTrue(hash.contains(1000000));
    // Assert.assertFalse(hash.contains(-1));
    Assert.assertFalse(hash.contains(56));

    hash.remove(1000000);
    Assert.assertTrue(hash.contains(0));
    Assert.assertTrue(hash.contains(1));
    Assert.assertTrue(hash.contains(2));
    Assert.assertTrue(hash.contains(47));
    Assert.assertFalse(hash.contains(1000000));

    hash.remove(0);
    Assert.assertFalse(hash.contains(0));
    Assert.assertTrue(hash.contains(1));
    Assert.assertTrue(hash.contains(2));
    Assert.assertTrue(hash.contains(47));
    Assert.assertFalse(hash.contains(1000000));
  }

  // @Test
  public void testHashMap() {
    final HashMap<Integer, Object> m = new HashMap<>();

    m.put(4, new Object());
    m.put(2, new Object());
    m.put(3, new Object());
    m.put(1, new Object());
    m.put(1, new Object());
    m.put(4, new Object());
    m.put(5, new Object());
    m.put(6, new Object());

    for (final Integer key : m.keySet()) {
      System.out.println(key);
    }
  }
}
