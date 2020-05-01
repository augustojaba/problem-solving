package com.jaba.code.leetcode.problemsolving.problems;

public class NumberofIslands {

  static boolean isSafe(final char[][] M, final int row, final int col, final boolean[][] visited) {
    return (row >= 0)
        && (row < M.length)
        && (col >= 0)
        && (col < M[0].length)
        && (M[row][col] == '1' && !visited[row][col]);
  }

  static void DFS(final char[][] M, final int row, final int col, final boolean[][] visited) {
    final int[] rowNbr = new int[] {-1, 0, 1, 0};
    final int[] colNbr = new int[] {0, -1, 0, 1};

    visited[row][col] = true;

    for (int k = 0; k < 4; ++k) {
      if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
        DFS(M, row + rowNbr[k], col + colNbr[k], visited);
      }
    }
  }

  static int numIslands(final char[][] M) {

    if (M.length == 0) return 0;

    final boolean[][] visited = new boolean[M.length][M[0].length];

    int count = 0;
    for (int i = 0; i < M.length; ++i) {
      for (int j = 0; j < M[0].length; ++j) {
        if (M[i][j] == '1' && !visited[i][j]) {
          DFS(M, i, j, visited);
          ++count;
        }
      }
    }

    return count;
  }

  public static void main(final String[] args) {
    final char[][] entry = createEntryFromString("11000\n" + "11000\n" + "00100\n" + "00011");
    //    final char[][] entry = createEntryFromString("111\n" + "010\n" + "111\n");
    System.out.println(numIslands(entry));
  }

  private static char[][] createEntryFromString(final String s) {
    final String[] split = s.split("\n");
    final char[][] result = new char[split.length][split[0].length()];

    for (int i = 0; i < split.length; i++) {
      final String line = split[i].trim();
      System.out.println(i);
      System.out.println(line);
      result[i] = line.toCharArray();
    }
    return result;
  }
}
