package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution5 {

  public static void main(String[] args) {
    Solution5 s = new Solution5();

    System.out.println(
        Arrays.toString(
            s.findRestaurant(
                new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[] {"KFC", "Shogun", "Burger King"})));
  }

  public String[] findRestaurant(String[] list1, String[] list2) {

    String[] greater = list1.length > list2.length ? list1 : list2;
    String[] smaller = list1.length <= list2.length ? list1 : list2;

    Map<String, Integer> map = new HashMap<>();
    String[] solution = new String[smaller.length];
    int min = Integer.MAX_VALUE;
    int indexSolution = 0;

    for (int i = 0; i < greater.length; i++) {
      map.put(greater[i], i);
    }

    for (int i = 0; i < smaller.length; i++) {
      if (map.containsKey(smaller[i]) && map.get(smaller[i]) + i < min) {
        solution = new String[smaller.length];
        indexSolution = 0;
        solution[indexSolution++] = smaller[i];
        min = map.get(smaller[i]) + i;
        indexSolution = 1;
      } else if (map.containsKey(smaller[i]) && map.get(smaller[i]) + i == min) {
        solution[indexSolution++] = smaller[i];
      }
    }

    return Arrays.copyOf(solution, indexSolution);
  }
}
