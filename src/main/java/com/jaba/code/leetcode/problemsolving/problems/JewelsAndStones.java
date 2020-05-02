package com.jaba.code.leetcode.problemsolving.problems;

import java.util.stream.Collectors;

public class JewelsAndStones {

  public int numJewelsInStones(final String J, final String S) {
    return (int) S.chars().filter(J.chars().boxed().collect(Collectors.toSet())::contains).count();
  }

  public static void main(final String[] args) {
    System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
  }
}
