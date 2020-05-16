package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-16
 */
public class MaximumSumCircularSubarrayTest {

  @Test
  public void maxSubarraySumCircular_Test1() {
    final int maxSum =
        new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[] {5, -3, 5});
    assertEquals(10, maxSum);
  }
}
