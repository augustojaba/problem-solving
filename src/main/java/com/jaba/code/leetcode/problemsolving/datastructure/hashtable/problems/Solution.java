package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> auxSet = new HashSet<>();
        
        for (int i: nums) {
            if (auxSet.contains(i)) {
                return true;
            }
            
            auxSet.add(i);
        }
        
        return false;
    }
}