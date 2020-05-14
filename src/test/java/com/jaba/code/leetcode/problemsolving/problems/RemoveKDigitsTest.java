package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveKDigitsTest {

  @Test
  public void removeKdigits_Test1() {
    assertEquals("200", new RemoveKDigits().removeKdigits("10200", 1));
  }
}
