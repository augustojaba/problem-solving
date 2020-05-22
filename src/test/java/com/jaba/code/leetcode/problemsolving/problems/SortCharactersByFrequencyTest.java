package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-22
 */
public class SortCharactersByFrequencyTest {

  @Test
  public void frequencySort_Test1() {
    Assert.assertEquals("aaaccb", new SortCharactersByFrequency().frequencySort("aaabcc"));
  }

  @Test
  public void frequencySort_TestUpperCase() {
    Assert.assertEquals("bbAa", new SortCharactersByFrequency().frequencySort("Aabb"));
  }

  @Test
  public void frequencySort_TestWithNumbers() {
    Assert.assertEquals(
        "sssssssffffff44444aaaa55522",
        new SortCharactersByFrequency().frequencySort("2a554442f544asfasssffffasss"));
  }
}
