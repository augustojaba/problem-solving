package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-19
 */
public class PermutationInStringTest {

  @Test
  public void checkInclusion_Test1() {
    Assert.assertTrue(new PermutationInString().checkInclusion("ab", "eidbaooo"));
  }

  @Test
  public void checkInclusion_Test2() {
    Assert.assertFalse(new PermutationInString().checkInclusion("ab", "eidboaoo"));
  }

  @Test
  public void checkInclusion_Test3() {
    Assert.assertTrue(new PermutationInString().checkInclusion("adc", "dcda"));
  }
}
