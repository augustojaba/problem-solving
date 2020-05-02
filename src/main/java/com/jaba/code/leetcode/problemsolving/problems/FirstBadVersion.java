package com.jaba.code.leetcode.problemsolving.problems;

public class FirstBadVersion {

  public static final int SOLUTION = 1;

  public int firstBadVersion(final int n) {

    int left = 1;
    int right = n;

    while (left < right) {
      final int mid = left + (right - left) / 2;

      if (isBadVersion(mid)) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return right;
  }

  public static void main(final String[] args) {

    System.out.println(new FirstBadVersion().firstBadVersion(5));
  }

  private boolean isBadVersion(final int n) {
    return n >= SOLUTION;
  }
}
