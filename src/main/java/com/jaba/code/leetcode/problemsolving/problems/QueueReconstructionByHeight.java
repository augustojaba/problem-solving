package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-06
 */
public class QueueReconstructionByHeight {
  public int[][] reconstructQueue(final int[][] people) {

    if (people == null || people.length == 0 || people.length == 1) {
      return people;
    }

    Arrays.sort(
        people,
        (a, b) -> {
          if (a[0] == b[0]) {
            return a[1] - b[1];
          } else {
            return b[0] - a[0];
          }
        });

    final List<int[]> reconstructedQueue = new ArrayList<>();

    for (final int[] p : people) {
      reconstructedQueue.add(p[1], p);
    }
    return reconstructedQueue.toArray(new int[0][0]);
  }

  @Test
  public void test_HappyPath() {
    final QueueReconstructionByHeight queueReconstructionByHeight =
        new QueueReconstructionByHeight();
    final int[][] result =
        queueReconstructionByHeight.reconstructQueue(
            new int[][] {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
    Assert.assertArrayEquals(new int[][] {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}, result);
  }
}
