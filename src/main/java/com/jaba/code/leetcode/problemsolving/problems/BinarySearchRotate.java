package com.jaba.code.leetcode.problemsolving.problems;

public class BinarySearchRotate {

  static int binarySearch(int[] ints, int k) {
    if (null == ints || 0 == ints.length) {
      return -1;
    }

    int left = 0;
    int right = ints.length - 1;

    // find where it starts
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (ints[mid] > ints[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    int start = left;
    left = 0;
    right = ints.length - 1;

    if (k >= ints[start] && k <= ints[right]) {
      left = start;
    } else {
      right = start;
    }

    // regular binary search
    while (left <= right) {

      int mid = left + (right - left) / 2;

      if (k == ints[mid]) {
        return mid;
      } else if (k <= ints[mid]) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(BinarySearchRotate.binarySearch(new int[] {4, 5, 6, 7, 0, 1, 2}, 1));
  }
}
