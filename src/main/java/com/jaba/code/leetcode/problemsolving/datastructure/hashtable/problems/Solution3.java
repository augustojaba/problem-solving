package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution3 {
    public int[] intersection(int[] nums1, int[] nums2) {

        List<Integer> solution = new ArrayList<>();
        Set<Integer> auxSet = new HashSet<>();

        int[] smaller = null;

        if (nums1.length > nums2.length) {
            this.addAll(nums1, auxSet);
            smaller = nums2;
        } else {
            this.addAll(nums2, auxSet);
            smaller = nums1;
        }

        for (int i: smaller) {
            if (auxSet.contains(i)) {
                solution.add(i);
            }
        }

        return solution.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    private void addAll(int[] source, Set<Integer> target) {
        for(int i: source) {
            target.add(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}