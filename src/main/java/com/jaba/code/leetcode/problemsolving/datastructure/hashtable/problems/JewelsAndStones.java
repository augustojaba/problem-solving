package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

public class JewelsAndStones {

    public int numJewelsInStones(String j, String s) {

        final char[] input = s.toCharArray();
        //final Set<Character> set = new HashSet(Arrays.asList(j.toCharArray()));

        int result = 0;

        for (char c: input) {
            if (j.indexOf(c) >= 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
    }
}
