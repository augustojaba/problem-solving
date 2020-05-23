package com.jaba.code.leetcode.problemsolving;

import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-23
 */
public class IntervalListSectionsTest {

  @Test
  public void intervalIntersection() {
    new IntervalListSections()
        .intervalIntersection(
            new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
            new int[][] {{1, 5}, {8, 12}, {15, 24}, {25, 26}});
    System.out.println();
  }
}
