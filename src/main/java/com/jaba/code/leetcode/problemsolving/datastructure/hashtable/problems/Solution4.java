package com.jaba.code.leetcode.problemsolving.datastructure.hashtable.problems;

public class Solution4 {

  public boolean isHappy(int n) {
    int solution = n;

    while (solution != 1) {
      int aux = solution;

      int sum = 0;

      while (aux > 0) {
        sum = sum + (aux % 10) * (aux % 10);
        aux /= 10;
      }
      solution = sum;
    }

    return true;
  }
}
