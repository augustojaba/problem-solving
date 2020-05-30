package com.jaba.code.leetcode.problemsolving.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-29
 */
public class CourseScheduleTest {

  @Test
  public void namecanFinish_Test1() {
    final CourseSchedule test = new CourseSchedule();
    Assert.assertTrue(test.canFinish(2, new int[][] {{1, 0}}));
  }

  @Test
  public void namecanFinish_Test2() {
    final CourseSchedule test = new CourseSchedule();
    Assert.assertFalse(test.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
  }
}
