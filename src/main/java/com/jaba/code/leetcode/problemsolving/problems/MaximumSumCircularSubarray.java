package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-16
 */
public class MaximumSumCircularSubarray {

  public int maxSubarraySumCircular(final int[] A) {

    int totalSum = 0;
    int maxSumCase1 = 0;
    int maxSumCase2 = 0;
    int sumCase1 = 0;
    int sumCase2 = 0;

    int min = Integer.MIN_VALUE;
    boolean hasPositive = false;

    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0) {
        hasPositive = true;
      }

      if (A[i] > min) {
        min = A[i];
      }
    }

    if (!hasPositive) {
      return min;
    }

    for (int i = 0; i < A.length; i++) {
      totalSum += A[i];

      sumCase1 += A[i];
      A[i] *= -1;
      sumCase2 += A[i];

      if (sumCase1 < 0) {
        sumCase1 = 0;
      } else {
        maxSumCase1 = Math.max(sumCase1, maxSumCase1);
      }

      if (sumCase2 < 0) {
        sumCase2 = 0;
      } else {
        maxSumCase2 = Math.max(sumCase2, maxSumCase2);
      }
    }

    return Math.max(maxSumCase1, totalSum + maxSumCase2);
  }
}
