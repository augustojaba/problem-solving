package com.jaba.code.leetcode.problemsolving.problems;

import java.util.HashMap;

class FirstUnique {

  private NodeList head;
  private NodeList tail;
  private final HashMap<Integer, NodeList> map;

  public FirstUnique(final int[] nums) {

    map = new HashMap<>();

    for (final int i : nums) {
      add(i);
    }
  }

  private void initializeHeadAndTail(final NodeList newNode) {
    head = newNode;
    tail = newNode;
  }

  public int showFirstUnique() {
    return head != null ? head.value : -1;
  }

  public void add(final int value) {
    NodeList nodeList = map.get(value);

    if (nodeList != null) {
      nodeList.count = nodeList.count + 1;
    } else {
      nodeList = new NodeList(value, 1);
      map.put(value, nodeList);
    }

    if (nodeList.count == 2) {
      removeNode(nodeList);
    } else if (nodeList.count == 1) {
      addLast(nodeList);
    }
  }

  private void removeNode(final NodeList nodeList) {
    if (nodeList == tail) {
      removeTail();
    } else if (nodeList == head) {
      removeHead();
    } else {
      removeNodeNonTail(nodeList);
    }
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

  private void removeNodeNonTail(final NodeList nodeList) {
    nodeList.previous.next = nodeList.next;
    nodeList.next.previous = nodeList.previous;
  }

  private void removeHead() {
    head.next.previous = null;
    head = head.next;
  }

  private void addLast(final NodeList nodeList) {

    if (tail == null && head == null) {
      initializeHeadAndTail(nodeList);
    } else {
      tail.next = nodeList;
      nodeList.previous = tail;
      tail = nodeList;
      nodeList.next = null;
    }
  }

  class NodeList {
    int value;
    int count;
    NodeList next;
    NodeList previous;

    NodeList(final int value, final int count) {
      this.value = value;
      this.count = count;
    }
  }

  public static void main(final String[] args) {
    final FirstUnique fq = new FirstUnique(new int[] {7, 7, 7, 7, 7, 7});
    System.out.println(fq.showFirstUnique());
    fq.add(7);
    fq.add(3);
    fq.add(3);
    fq.add(7);
    fq.add(17);
    System.out.println(fq.showFirstUnique());
  }
}
