package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-22
 */
public class SortCharactersByFrequency {

  public String frequencySort(final String s) {

    if (s == null || s.length() < 3) {
      return s;
    }

    final int[] freqCharacters = new int[255];
    int maxCount = 0;

    for (int i = 0; i < s.length(); i++) {
      final int count = ++freqCharacters[(int) s.charAt(i)];
      if (maxCount < count) {
        maxCount = count;
      }
    }

    final StringBuilder[] buckets = new StringBuilder[maxCount + 1];

    for (int i = 0; i < 255; i++) {

      final char newChar = (char) (i);
      final int freq = freqCharacters[i];

      if (buckets[freq] == null) {
        buckets[freq] = new StringBuilder();
      }

      if (freq > 0) {
        for (int j = 0; j < freq; j++) {
          buckets[freq].append(newChar);
        }
      }
    }

    final StringBuilder result = new StringBuilder();
    for (int i = maxCount; i > 0; i--) {
      if (buckets[i] != null) {
        result.append(buckets[i]);
      }
    }

    return result.toString();
  }
}
