package com.jaba.code.leetcode.problemsolving.problems;

import java.util.HashMap;

public class LRUCache {

  private final NodeList head;
  private final NodeList tail;
  private final HashMap<Integer, NodeList> cache;
  private final int capacity;

  public LRUCache(int capacity) {
    cache = new HashMap<>(capacity);
    this.capacity = capacity;
    head = null;
    tail = null;
  }

  public int get(int key) {

    if (cache.containsKey(key)) {
      NodeList existingNode = cache.get(key);
      moveFirst(existingNode);
      return existingNode.value;
    } else {
      return -1;
    }
  }

  private void moveFirst(NodeList nodeList) {}

  public void put(int key, int value) {
    /*if (!cache.containsKey(key)) {
      if (capacity >= cache.size()) {}

      cache.remove(list.get(list.size() - cache.size() - 1));
      cache.put(key, value);
    }*/
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
  }

  class NodeList {
    int value;
    NodeList next;
    NodeList previous;

    NodeList(int value) {
      this.value = value;
      previous = null;
      next = null;
    }
  }
}
