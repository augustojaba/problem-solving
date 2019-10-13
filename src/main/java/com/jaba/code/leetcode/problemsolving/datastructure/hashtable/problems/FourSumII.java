package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.HashMap;

public class FourSumII {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a: A) {
            for (int b: B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int c: C) {
            for (int d: D) {
                int sum = -(c + d);

                if (map.containsKey(sum)) {
                    result += map.get(sum);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumII().fourSumCount(
           new int[] {1,2},
           new int[] {-2,-1},
           new int[] {-1,2},
           new int[] {0,2}
        ));
    }
}
