package com.jaba.code.leetcode.problemsolving.problems;

import java.util.HashMap;

public class LRUCache {

  private NodeList head;
  private NodeList tail;
  private final HashMap<Integer, NodeList> cache;
  private final int capacity;

  public LRUCache(int capacity) {
    cache = new HashMap<>(capacity);
    this.capacity = capacity;
  }

  private void initializeHeadAndTail(NodeList newNode) {
    head = newNode;
    tail = newNode;
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

  private void moveFirst(NodeList nodeList) {
    if (nodeList == head) {
      return;
    } else {
      if (nodeList == tail) {
        removeTail();
      } else {
        removeNodeNonTail(nodeList);
      }
      updateHead(nodeList);
    }
  }

  private void removeNodeNonTail(NodeList nodeList) {
    nodeList.previous.next = nodeList.next;
    nodeList.next.previous = nodeList.previous;
  }

  private void removeTail() {
    if (tail.previous != null) {
      tail.previous.next = null;
      tail = tail.previous;
    } else {
      tail = null;
      head = null;
    }
  }

  private void updateHead(NodeList nodeList) {
    head.previous = nodeList;
    nodeList.next = head;
    head = nodeList;
    nodeList.previous = null;
  }

  public void put(int key, int value) {
    if (!cache.containsKey(key)) {
      if (capacity > cache.size()) {
        NodeList newNode = new NodeList(key, value);
        cache.put(key, newNode);
        if (null == head && null == tail) {
          initializeHeadAndTail(newNode);
        } else {
          updateHead(newNode);
        }
      } else {
        cache.remove(tail.key);
        removeTail();
        put(key, value);
      }
    } else {
      NodeList nodeList = cache.get(key);
      nodeList.value = value;
      moveFirst(nodeList);
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println(lruCache.get(1));
    lruCache.put(3, 3);
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(1));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));
  }

  class NodeList {
    int key;
    int value;
    NodeList next;
    NodeList previous;

    NodeList(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
