package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-02
 */
public class PlusOneTest {

  @Test
  public void plusOne() {
    Assert.assertEquals(new int[] {1, 0}, new PlusOne().plusOne(new int[] {9}));
  }
}
