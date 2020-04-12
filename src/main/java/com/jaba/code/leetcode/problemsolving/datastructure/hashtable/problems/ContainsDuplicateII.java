package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

  public static void main(String[] args) {
    System.out.println(
        new ContainsDuplicateII().containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (map.putIfAbsent(nums[i], i) != null) {
        if (Math.abs(map.get(nums[i]) - i) <= k) {
          return true;
        } else {
          map.put(nums[i], i);
        }
      }
    }

    Arrays.stream(new String[] {})
        .forEach(
            str -> {
              final char[] toSort = str.toCharArray();
              Arrays.sort(toSort);
              final String anaKey = new String(toSort);
            });

    return false;
  }
}
