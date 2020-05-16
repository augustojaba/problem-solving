package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-16
 */
public class OddEvenLinkedList {

  public ListNode oddEvenList(final ListNode head) {

    if (null == head || null == head.next) {
      return head;
    }

    final int pace = 1;
    ListNode previous = head;
    final ListNode startEvenBlock = head.next;
    ListNode endEvenBlock = startEvenBlock;

    while (null != endEvenBlock && null != endEvenBlock.next) {
      previous.next = endEvenBlock.next;
      endEvenBlock.next = endEvenBlock.next.next;
      previous.next.next = startEvenBlock;

      endEvenBlock = endEvenBlock.next;
      previous = previous.next;
    }

    return head;
  }
}
