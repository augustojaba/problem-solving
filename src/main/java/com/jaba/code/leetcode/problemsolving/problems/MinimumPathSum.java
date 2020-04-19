package com.jaba.code.leetcode.problemsolving.problems;

public class MinimumPathSum {

  static int minPathSum(int[][] grid) {

    int rows = grid.length;
    if (rows == 0) {
      return 0;
    }

    int columns = grid[0].length;
    if (columns == 0) {
      return 0;
    }

    // Initial and neighbours
    grid[0][0] = grid[0][0];

    for (int i = 1; i < columns; i++) {
      grid[0][i] = grid[0][i - 1] + grid[0][i];
    }

    for (int i = 1; i < rows; i++) {
      grid[i][0] = grid[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < rows; i++) {
      for (int j = 1; j < columns; j++) {
        if (grid[i - 1][j] < grid[i][j - 1]) {
          grid[i][j] = grid[i - 1][j] + grid[i][j];
        } else {
          grid[i][j] = grid[i][j - 1] + grid[i][j];
        }
      }
    }

    return grid[rows - 1][columns - 1];
  }

  public static void main(String[] args) {
    System.out.println(
        MinimumPathSum.minPathSum(
            new int[][] {
              {1, 3, 1},
              {1, 5, 1},
              {4, 2, 1}
            }));
  }
}
