package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

public class SingleElementInASortedArrayTest {

  @Test
  public void singleNonDuplicate_Test1() {
    Assert.assertEquals(
        2, new SingleElementInASortedArray().singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4}));
  }

  @Test
  public void singleNonDuplicate_Test2() {
    Assert.assertEquals(
        10,
        new SingleElementInASortedArray().singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11}));
  }

  @Test
  public void singleNonDuplicate_Test3() {
    Assert.assertEquals(
        2,
        new SingleElementInASortedArray()
            .singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
  }

  @Test
  public void singleNonDuplicate_Test4() {
    Assert.assertEquals(
        1, new SingleElementInASortedArray().singleNonDuplicate(new int[] {1, 2, 2, 3, 3}));
  }
}
