package com.jaba.code.leetcode.problemsolving.problems;

public class ValidPerfectSquare {
  public boolean isPerfectSquare(final int num) {

    long left = 1;
    long right = 50000;

    while (left < right) {
      final long mid = left + (right - left) / 2;
      final long midSquare = mid * mid;

      if (num == midSquare) {
        return true;
      } else if (num > midSquare) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return false;
  }

  public static void main(final String[] args) {
    System.out.println(new ValidPerfectSquare().isPerfectSquare(2147395600));
  }
}
