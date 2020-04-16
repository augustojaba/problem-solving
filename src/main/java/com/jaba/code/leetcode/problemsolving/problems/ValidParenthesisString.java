package com.jaba.code.leetcode.problemsolving.problems;

public class ValidParenthesisString {
  private static boolean checkValidString(String s) {
    int minLeft = 0;
    int maxLeft = 0;

    for (char c : s.toCharArray()) {
      if ('(' == c) {
        minLeft++;
      } else {
        minLeft--;
      }

      if (')' != c) {
        maxLeft++;
      } else {
        maxLeft--;
      }

      if (maxLeft < 0) {
        return false;
      }

      minLeft = Math.max(0, minLeft);
    }

    return minLeft == 0;
  }

  public static void main(String[] args) {
    System.out.println(ValidParenthesisString.checkValidString("(*))))))"));
  }
}
