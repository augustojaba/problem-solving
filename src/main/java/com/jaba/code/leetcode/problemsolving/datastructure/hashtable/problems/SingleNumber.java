package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.HashSet;
import java.util.Set;

class SingleNumber {
    public int singleNumber(int[] nums) {

        int solution = -1;

        Set<Integer> auxSet = new HashSet<>();

        auxSet.stream()
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i: nums) {
            if (auxSet.contains(i)) {
                auxSet.remove(i);
            } else {
                auxSet.add(i);
            }

        }

        for(int i: auxSet)
            solution = i;

        return solution;
    }

    public static void main(String[] args) {
        System.out.println(1 ^ 1);
    }
}