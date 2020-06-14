package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-14
 */
public class CheapestFlightsWithinKStops {

  public int findCheapestPrice(
      final int n, final int[][] flights, final int src, final int dst, final int K) {

    if (flights.length == 0) {
      return -1;
    }

    final ArrayList<List<Edge>> adjacencyList = new ArrayList<>();
    buildAdjacencyList(adjacencyList, n, flights);

    final Queue<City> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.costFromSource));
    pq.add(new City(src, 0, 0));

    while (!pq.isEmpty()) {
      final City cheapest = pq.poll();

      if (cheapest.city == dst) {
        return cheapest.costFromSource;
      }

      if (cheapest.distFromSource > K) {
        continue;
      }

      for (final Edge neigh : adjacencyList.get(cheapest.city)) {
        pq.add(
            new City(
                neigh.city, cheapest.distFromSource + 1, cheapest.costFromSource + neigh.cost));
      }
    }

    return -1;
  }

  private void buildAdjacencyList(
      final List<List<Edge>> adjacencyList, final int n, final int[][] flights) {

    for (int i = 0; i < n; i++) {
      adjacencyList.add(new ArrayList<>());
    }

    for (final int[] flight : flights) {
      adjacencyList.get(flight[0]).add(new Edge(flight[1], flight[2]));
    }
  }

  class Edge {
    int city, cost;

    Edge(final int city, final int cost) {
      this.city = city;
      this.cost = cost;
    }
  }

  class City {
    int city, distFromSource, costFromSource;

    City(final int city, final int distFromSource, final int costFromSource) {
      this.city = city;
      this.distFromSource = distFromSource;
      this.costFromSource = costFromSource;
    }
  }

  @Test
  public void test_CaseBasic() {
    Assert.assertEquals(
        200,
        new CheapestFlightsWithinKStops()
            .findCheapestPrice(3, new int[][] {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
  }
}
