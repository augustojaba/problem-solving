package com.jaba.code.leetcode.problemsolving.problems;

import java.util.PriorityQueue;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-30
 */
public class KClosestPointsToOrigin {

  public int[][] kClosest(final int[][] points, final int K) {

    final PriorityQueue<Entry> pq =
        new PriorityQueue<>((e1, e2) -> Double.compare(e2.distance, e1.distance));

    for (final int[] point : points) {
      pq.add(new Entry(calculateDistanceToOrigin(point), point));
    }

    final int[][] result = new int[K][2];

    for (int i = 0; i < K; i++) {
      result[i] = pq.poll().point;
    }

    return result;
  }

  private Double calculateDistanceToOrigin(final int[] point) {
    return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
  }

  class Entry {
    Double distance;
    int[] point;

    public Entry(final Double distance, final int[] point) {
      this.distance = distance;
      this.point = point;
    }
  }
}
