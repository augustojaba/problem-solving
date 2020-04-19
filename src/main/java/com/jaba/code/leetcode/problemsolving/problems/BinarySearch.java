package com.jaba.code.leetcode.problemsolving.problems;

public class BinarySearch {

  static int binarySearch(int[] ints, int k) {
    if (0 == ints.length) {
      return -1;
    } else if (k < ints[0] && k > ints[ints.length - 1]) {
      return -1;
    } else {
      int left = 0;
      int right = ints.length - 1;

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
  }

  public static void main(String[] args) {
    System.out.println(BinarySearch.binarySearch(new int[] {-9, 14, 37, 102}, 14));
  }
}
