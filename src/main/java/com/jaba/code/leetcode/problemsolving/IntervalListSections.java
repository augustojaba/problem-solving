package com.jaba.code.leetcode.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-23
 */
public class IntervalListSections {

  public int[][] intervalIntersection(final int[][] A, final int[][] B) {

    int indexA = 0, indexB = 0;
    final List<int[]> result = new ArrayList<>();

    while (indexA < A.length && indexB < B.length) {

      if (A[indexA][0] >= B[indexB][0]) {
        if (A[indexA][0] > B[indexB][1]) {
          indexB++;
          continue;
        }
        if (A[indexA][1] >= B[indexB][1]) {
          result.add(new int[] {A[indexA][0], B[indexB][1]});
          indexB++;
        } else {
          result.add(new int[] {A[indexA][0], A[indexA][1]});
          indexA++;
        }
      } else {

        if (B[indexB][0] > A[indexA][1]) {
          indexA++;
          continue;
        }

        if (A[indexA][1] >= B[indexB][1]) {
          result.add(new int[] {B[indexB][0], B[indexB][1]});
          indexB++;
        } else {
          result.add(new int[] {B[indexB][0], A[indexA][1]});
          indexA++;
        }
      }
    }

    return result.toArray(new int[result.size()][]);
  }
}
