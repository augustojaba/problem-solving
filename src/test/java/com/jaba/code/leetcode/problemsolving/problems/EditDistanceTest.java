package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-31
 */
public class EditDistanceTest {

  @Test
  public void minDistance_Test1() {
    Assert.assertEquals(7, new EditDistance().minDistance("augusto", "livia"));
  }
}
