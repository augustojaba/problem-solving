package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-17
 */
public class FindAllAnagramsInAStringTest {

  @Test
  public void findAnagrams() {
    final List<Integer> result = new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc");

    assertEquals(2, result.size());
    assertEquals(0, result.get(0).intValue());
    assertEquals(6, result.get(1).intValue());
  }
}
