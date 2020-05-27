package com.jaba.code.leetcode.problemsolving.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-27
 */
public class PossibleBipartition {

  public boolean possibleBipartition(final int N, final int[][] dislikes) {

    if (dislikes.length == 0) {
      return true;
    }

    final Map<Integer, List<Integer>> map = new HashMap<>();

    for (int i = 0; i < dislikes.length; i++) {

      // Create the adjacency list X -> Y
      int key = dislikes[i][0];
      List<Integer> neighs = map.getOrDefault(key, new ArrayList<>());
      neighs.add(dislikes[i][1]);
      map.put(key, neighs);

      // Create the adjacency list Y -> X
      key = dislikes[i][1];
      neighs = map.getOrDefault(key, new ArrayList<>());
      neighs.add(dislikes[i][0]);
      map.put(key, neighs);
    }

    final int[] visited = new int[N];

    for (int i = 1; i <= N; i++) {
      if (visited[i - 1] == 0) {
        if (!dfs(i, 1, visited, map)) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean dfs(
      final int node, final int color, final int[] visited, final Map<Integer, List<Integer>> map) {
    if (visited[node - 1] != 0 && visited[node - 1] != color) {
      return false;
    }

    if (visited[node - 1] == color) {
      return true;
    }

    visited[node - 1] = color;

    final List<Integer> neighs = map.get(node);

    if (neighs == null) {
      return true;
    }

    for (final Integer neigh : neighs) {
      if (!dfs(neigh, -1 * color, visited, map)) {
        return false;
      }
    }
    return true;
  }
}
