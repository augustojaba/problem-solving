package com.jaba.code.leetcode.problemsolving.problems;

public class NumberofIslands {

  private static int numIslands(char[][] grid) {

    int count = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {}
    }

    return count;
  }

  public static void main(String[] args) {
    //    char[][] entry = createEntryFromString("11000\n" + "11000\n" + "00100\n" + "00011");
    char[][] entry = createEntryFromString("111\n" + "010\n" + "111\n");
    System.out.println(numIslands(entry));
  }

  private static char[][] createEntryFromString(String s) {
    String[] split = s.split("\n");
    char[][] result = new char[split.length][split[0].length()];

    for (int i = 0; i < split.length; i++) {
      String line = split[i].trim();
      System.out.println(i);
      System.out.println(line);
      result[i] = line.toCharArray();
    }
    return result;
  }
}
