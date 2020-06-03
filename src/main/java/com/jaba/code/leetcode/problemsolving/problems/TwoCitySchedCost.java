package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-03
 */
public class TwoCitySchedCost {

  public int twoCitySchedCost(final int[][] costs) {

    Arrays.sort(costs, (e1, e2) -> (Math.abs(e2[0] - e2[1])) - (Math.abs(e1[0] - e1[1])));

    int countA = 0, countB = 0, result = 0;

    for (int i = 0; i < costs.length; i++) {
      if ((costs[i][0] < costs[i][1] && countA < costs.length / 2) || countB == costs.length / 2) {
        countA++;
        result += costs[i][0];
      } else {
        countB++;
        result += costs[i][1];
      }
    }

    return result;
  }

  @Test
  public void test_EquallyDistributedMin() {
    Assert.assertEquals(
        110,
        new TwoCitySchedCost()
            .twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
  }

  @Test
  public void test_NotEquallyDistributedMin() {
    Assert.assertEquals(
        120,
        new TwoCitySchedCost()
            .twoCitySchedCost(new int[][] {{10, 20}, {30, 200}, {50, 400}, {30, 20}}));
  }

  @Test
  public void test_case27() {
    Assert.assertEquals(
        3671,
        new TwoCitySchedCost()
            .twoCitySchedCost(
                new int[][] {
                  {518, 518},
                  {71, 971},
                  {121, 862},
                  {967, 607},
                  {138, 754},
                  {513, 337},
                  {499, 873},
                  {337, 387},
                  {647, 917},
                  {76, 417}
                }));
  }
}
