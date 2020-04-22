package com.jaba.code.leetcode.problemsolving.problems;

import java.util.List;

public class LeftmostColumnWithAtLeastAOne {

  public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
    Integer right = binaryMatrix.dimensions().get(1);
    int left = 0;
    int result = -1;

    for (int i = 0; i <= binaryMatrix.dimensions().get(0); i++) {

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (1 == binaryMatrix.get(i, mid)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      result = right;

      if (0 == result) {
        return 0;
      }
    }
    return result;
  }
}

interface BinaryMatrix {
  public int get(int x, int y);

  public List<Integer> dimensions();
}
