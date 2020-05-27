package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FloodFillTest {

  @Test
  public void floodFill() {
    final int[][] imageResult =
        new FloodFill().floodFill(new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);

    System.out.println(Arrays.toString(imageResult));
  }

  @Test
  public void tes() {
    final Map<Integer, Integer> m = new HashMap<>();
    System.out.println(1 - m.get(1));
  }
}
