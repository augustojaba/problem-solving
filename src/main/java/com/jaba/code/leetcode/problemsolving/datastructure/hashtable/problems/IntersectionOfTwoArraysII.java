package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        int[] greater = nums1.length > nums2.length ? nums1 : nums2;
        int[] smaller = nums1.length <= nums2.length ? nums1 : nums2;

        int[] solution = new int[smaller.length];
        Map<Integer, Integer> map = new HashMap<>();

        int indexSolution = 0;

        for (int i : greater) {
            if (map.putIfAbsent(i, 1) != null) {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int i = 0; i < smaller.length; i++) {
            if (map.containsKey(smaller[i]) && map.get(smaller[i]) > 0) {
                solution[i] = smaller[i];
                map.put(smaller[i], map.get(smaller[i]) - 1);
                indexSolution ++;
            }
        }

        return Arrays.copyOf(solution, indexSolution);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(IntersectionOfTwoArraysII.intersect(new int[]{2, 1}, new int[]{1, 1})));
    }
}
