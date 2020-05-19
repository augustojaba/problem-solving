package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-19
 */
public class PermutationInString {

  public boolean checkInclusion(final String s1, final String s2) {

    final int[] map = new int[26];

    for (final char c : s1.toCharArray()) {
      map[c - 'a']++;
    }

    int count = s1.length();
    int start = 0;

    for (int i = 0; i < s2.length(); i++) {

      if (map[s2.charAt(i) - 'a']-- > 0) {
        count--;
      }

      if (count == 0) {
        return true;
      }

      if (i - start + 1 == s1.length() && map[s2.charAt(start++) - 'a']++ >= 0) {
        count++;
      }
    }

    return false;
  }
}
