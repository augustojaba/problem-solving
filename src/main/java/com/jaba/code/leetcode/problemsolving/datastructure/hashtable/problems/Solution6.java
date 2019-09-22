package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class Solution6 {

    public int firstUniqChar(String s) {

        if (s == null || s.isEmpty()) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }
}
