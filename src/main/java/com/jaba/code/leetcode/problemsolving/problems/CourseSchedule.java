package com.jaba.code.leetcode.problemsolving.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-29
 */
public class CourseSchedule {

  public boolean canFinish(final int numCourses, final int[][] prerequisites) {

    if (prerequisites.length == 0) {
      return true;
    }

    final Map<Integer, List<Integer>> adj = new HashMap<>();

    for (final int[] edge : prerequisites) {
      final int key = edge[0];
      final List<Integer> listVert = adj.computeIfAbsent(key, k -> new ArrayList<>());
      listVert.add(edge[1]);
    }

    final int[] labels = new int[numCourses];

    for (int node = 0; node < numCourses; node++) {
      if (!dfs(node, labels, adj)) {
        return false;
      }
    }

    return true;
  }

  private boolean dfs(final int node, final int[] labels, final Map<Integer, List<Integer>> adj) {

    if (labels[node] == -1) {
      return false;
    }

    if (labels[node] == 1) {
      return true;
    }

    labels[node] = -1;

    if (adj.containsKey(node)) {
      for (final int neigh : adj.get(node)) {
        if (!dfs(neigh, labels, adj)) {
          return false;
        }
      }
    }
    labels[node] = 1;
    return true;
  }
}
