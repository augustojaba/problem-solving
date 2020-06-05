package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-05
 */
public class RandomPickWithWeightTest {

  @Test
  public void test_MultiplesPicks() {
    final RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[] {4, 2});
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
    randomPickWithWeight.pickIndex();
  }
}
