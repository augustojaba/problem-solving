package com.jaba.code.leetcode.problemsolving.problems;

import java.util.HashMap;

public class LongestNonRepeatCharacterSubstring {

  public static void main(String[] args) {
    LongestNonRepeatCharacterSubstring program = new LongestNonRepeatCharacterSubstring();

    System.out.println(program.lengthOfLongestSubstring("aab"));
  }

  public int lengthOfLongestSubstring(String s) {

    HashMap<Character, Character> map = new HashMap<Character, Character>();

    String substring = s;
    int result = 0;
    int currentSize = 0;

    while (substring != null && substring.length() > 0) {
      char[] arr = substring.toCharArray();

      for (char c : arr) {
        if (!map.containsKey(c)) {
          map.put(c, c);
          currentSize++;
        } else {
          break;
        }
      }

      if (result < currentSize) {
        result = currentSize;
      }

      map = new HashMap<Character, Character>();
      currentSize = 0;
      substring = substring.substring(1);
    }

    return result;
  }
}
