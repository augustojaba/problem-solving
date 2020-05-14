package com.jaba.code.leetcode.problemsolving.problems;

import java.util.Stack;

public class RemoveKDigits {

  public String removeKdigits(final String num, int k) {

    final int size = num.length();
    if (k == size) {
      return "0";
    }

    final Stack<Character> stack = new Stack<>();

    int i = 0;
    while (i < size) {

      while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
        stack.pop();
        k--;
      }

      stack.push(num.charAt(i));
      i++;
    }

    while (k > 0) {
      stack.pop();
      k--;
    }

    final StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      if (stack.firstElement() == '0') {
        stack.remove(0);
        continue;
      }

      sb.append(stack.remove(0));
    }

    return sb.toString();
  }
}
