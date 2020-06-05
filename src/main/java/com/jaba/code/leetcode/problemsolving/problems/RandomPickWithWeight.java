package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-05
 */
public class RandomPickWithWeight {

  private final int[] prob;

  public RandomPickWithWeight(final int[] w) {
    prob = new int[w.length];
    int interval = 0;
    for (int i = 0; i < w.length; i++) {
      prob[i] = interval += w[i];
    }
  }

  public int pickIndex() {
    final double target = (prob[prob.length - 1]) * Math.random();

    int l = 0, r = prob.length - 1;
    int picked = -1;

    while (l <= r) {
      final int mid = l + (r - l) / 2;

      if (target < prob[mid]) {
        picked = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    return picked;
  }
}
