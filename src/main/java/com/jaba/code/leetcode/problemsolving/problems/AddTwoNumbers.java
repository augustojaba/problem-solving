package com.jaba.code.leetcode.problemsolving.problems;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    char[] sum = (String.valueOf(getNumber(l1).add(getNumber(l2)))).toCharArray();

    ListNode n = new ListNode(Character.getNumericValue(sum[0]));
    ListNode result = n;

    for (int i = 1; i < sum.length; i++) {
      result = new ListNode(Character.getNumericValue(sum[i]));
      result.next = n;
      n = result;
    }

    return result;
  }

  private BigInteger getNumber(ListNode l) {
    BigDecimal result = BigDecimal.ZERO;
    int i = 0;

    while (l != null) {
      result = result.add(BigDecimal.valueOf(l.val).multiply(BigDecimal.valueOf(Math.pow(10, i))));
      l = l.next;
      i++;
    }
    return result.toBigInteger();
  }
}

public class AddTwoNumbers {
  public static int[] stringToIntegerArray(String input) {
    input = input.trim();
    input = input.substring(1, input.length() - 1);
    if (input.length() == 0) {
      return new int[0];
    }

    String[] parts = input.split(",");
    int[] output = new int[parts.length];
    for (int index = 0; index < parts.length; index++) {
      String part = parts[index].trim();
      output[index] = Integer.parseInt(part);
    }
    return output;
  }

  public static ListNode stringToListNode(String input) {
    // Generate array from the input
    int[] nodeValues = stringToIntegerArray(input);

    // Now convert that list into linked list
    ListNode dummyRoot = new ListNode(0);
    ListNode ptr = dummyRoot;
    for (int item : nodeValues) {
      ptr.next = new ListNode(item);
      ptr = ptr.next;
    }
    return dummyRoot.next;
  }

  public static String listNodeToString(ListNode node) {
    if (node == null) {
      return "[]";
    }

    String result = "";
    while (node != null) {
      result += Integer.toString(node.val) + ", ";
      node = node.next;
    }
    return "[" + result.substring(0, result.length() - 2) + "]";
  }

  public static void main(String[] args) throws IOException {
    // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    // String line;
    /*while ((line = in.readLine()) != null) {
    	ListNode l1 = stringToListNode(line);
    	line = in.readLine();
    	ListNode l2 = stringToListNode(line);

    	ListNode ret = new Solution().addTwoNumbers(l1, l2);

    	String out = listNodeToString(ret);

    	System.out.print(out);
    }*/

    ListNode l1 =
        stringToListNode("[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]");
    // line = in.readLine();
    ListNode l2 = stringToListNode("[5,6,4]");

    ListNode ret = new Solution().addTwoNumbers(l1, l2);

    String out = listNodeToString(ret);

    System.out.print(out);

    do {} while (true);
  }
}

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}
