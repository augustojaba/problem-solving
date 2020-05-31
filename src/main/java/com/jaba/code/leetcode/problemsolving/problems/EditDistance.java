package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-31
 */
public class EditDistance {

  /**
   * Levesthein Algorithm - Dynamic Programming
   *
   * @param word1
   * @param word2
   * @return
   */
  public int minDistance(final String word1, final String word2) {

    if ((word1 == null || word1.isEmpty()) && (word2 == null || word2.isEmpty())) {
      return 0;
    }

    final int wl1 = word1.length();
    final int wl2 = word2.length();

    final int[][] dp = new int[wl1 + 1][wl2 + 1];

    for (int i = 1; i < wl1 + 1; i++) {
      dp[i][0] = i;
    }

    for (int i = 1; i < wl2 + 1; i++) {
      dp[0][i] = i;
    }

    for (int i = 1; i < wl1 + 1; i++) {
      for (int j = 1; j < wl2 + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
        }
      }
    }
    return dp[wl1][wl2];
  }
}
