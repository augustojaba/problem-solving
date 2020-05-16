package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-16
 */
public class OddEvenLinkedListTest {

  @Test
  public void oddEvenList_Test1() {

    final ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    final ListNode listNode = new OddEvenLinkedList().oddEvenList(root);

    assertEquals(1, listNode.val);
    assertEquals(3, listNode.next.val);
    assertEquals(5, listNode.next.next.val);
    assertEquals(2, listNode.next.next.next.val);
    assertEquals(4, listNode.next.next.next.next.val);
  }

  @Test
  public void oddEvenList_Test2() {

    final ListNode root = new ListNode(2);
    root.next = new ListNode(1);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(5);
    root.next.next.next.next = new ListNode(6);
    root.next.next.next.next.next = new ListNode(4);
    root.next.next.next.next.next.next = new ListNode(7);
    final ListNode listNode = new OddEvenLinkedList().oddEvenList(root);

    assertEquals(2, listNode.val);
    assertEquals(3, listNode.next.val);
    assertEquals(6, listNode.next.next.val);
    assertEquals(7, listNode.next.next.next.val);
    assertEquals(1, listNode.next.next.next.next.val);
    assertEquals(5, listNode.next.next.next.next.next.val);
    assertEquals(4, listNode.next.next.next.next.next.next.val);
  }

  @Test
  public void oddEvenList_TestNull() {

    final ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    root.next.next = new ListNode(3);
    root.next.next.next = new ListNode(4);
    root.next.next.next.next = new ListNode(5);
    final ListNode listNode = new OddEvenLinkedList().oddEvenList(null);

    assertNull(listNode);
  }

  @Test
  public void oddEvenList_TestOneElement() {

    final ListNode root = new ListNode(1);
    final ListNode listNode = new OddEvenLinkedList().oddEvenList(root);

    assertEquals(1, listNode.val);
    assertNull(listNode.next);
  }

  @Test
  public void oddEvenList_TestTwoElements() {

    final ListNode root = new ListNode(1);
    root.next = new ListNode(2);
    final ListNode listNode = new OddEvenLinkedList().oddEvenList(root);

    assertEquals(1, listNode.val);
    assertEquals(2, listNode.next.val);
    assertNull(listNode.next.next);
  }
}
