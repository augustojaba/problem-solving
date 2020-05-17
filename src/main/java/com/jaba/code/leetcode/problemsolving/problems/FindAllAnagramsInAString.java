package com.jaba.code.leetcode.problemsolving.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-17
 */
public class FindAllAnagramsInAString {

  public List<Integer> findAnagrams(final String s, final String p) {

    final List<Integer> result = new ArrayList<>();

    if (null == s || s.isEmpty()) {
      return result;
    }

    final int[] charCount = new int[26];

    for (final char c : p.toCharArray()) {
      charCount[c - 'a']++;
    }

    int winl = 0, winr = 0, count = p.length();

    while (winr < s.length()) {

      if (charCount[s.charAt(winr++) - 'a']-- > 0) {
        count--;
      }

      if (0 == count) {
        result.add(winl);
      }

      if (winr - winl == p.length() && charCount[s.charAt(winl++) - 'a']++ >= 0) {
        count++;
      }
    }

    return result;
  }
}
