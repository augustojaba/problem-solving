package com.jaba.code.leetcode.problemsolving.problems;

public class FloodFill {

  static final int[] rowNbr = new int[] {-1, 0, 1, 0};
  static final int[] colNbr = new int[] {0, -1, 0, 1};

  public int[][] floodFill(final int[][] image, final int sr, final int sc, final int newColor) {

    if (image[sr][sc] == newColor) {
      return image;
    }

    final int originalColor = image[sr][sc];
    DFS(image, sr, sc, originalColor, newColor);
    return image;
  }

  private void DFS(
      final int[][] image,
      final int row,
      final int col,
      final int originalColor,
      final int newColor) {

    image[row][col] = newColor;

    for (int i = 0; i < 4; i++) {
      if (isSafe(image, row + rowNbr[i], col + colNbr[i], originalColor)) {
        DFS(image, row + rowNbr[i], col + colNbr[i], originalColor, newColor);
      }
    }
  }

  private boolean isSafe(
      final int[][] image, final int row, final int col, final int originalColor) {
    return (row >= 0)
        && (row < image.length)
        && (col >= 0)
        && (col < image[0].length)
        && (image[row][col] == originalColor);
  }
}
