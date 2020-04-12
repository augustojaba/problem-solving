package com.jaba.code.leetcode.problemsolving.problems;

import java.util.HashMap;
import java.util.List;

public class ReverseInteger {

  private static final List<Character> valueOfCards =
      java.util.Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A');

  /*public static int reverse(int x) {
      if(x == 0) return x;

      String aux = x < 0? String.valueOf(x).substring(1): String.valueOf(x);
      String[] listDigits = aux.split("");

      int left = 0;
      int right = listDigits.length -1;

      while (left < right) {
          aux = listDigits[right];
          listDigits[right] = listDigits[left];
          listDigits[left] = aux;
          left++;
          right--;
      }

      //Long result = Long.valueOf(Arrays.toString(listDigits).replaceAll("\\[|\\]|,|\\s", ""))*(x < 0? -1: 1);
      if((result > 0 && result > Integer.MAX_VALUE) || result < 0 && result < Integer.MIN_VALUE)
          return 0;
      else
          return result.intValue();
  }*/

  public static int solution(String[] T, String[] R) {
    // write your code in Java SE 8

    if (T.length == 0 && R.length == 0) return 0;

    if (T.length != R.length) throw new RuntimeException();

    HashMap<String, Boolean> result = new HashMap<String, Boolean>();

    for (int i = 0; i < T.length; i++) {
      String nameGroup = null;

      if (T[i].matches(".*[a-z]$")) {
        nameGroup = T[i].substring(0, T[i].length() - 1);
      } else {
        nameGroup = T[i];
      }

      if (result.containsKey(nameGroup)) {
        if (result.get(nameGroup)) {
          result.put(nameGroup, "OK".equals(R[i].toUpperCase()));
        }
      } else {
        result.put(nameGroup, "OK".equals(R[i].toUpperCase()));
      }
    }

    int points = 0;
    for (Boolean correct : result.values()) {
      if (correct) points += 100;
    }

    return points / result.size();
  }

  public static void main(String[] args) {
    // System.out.println(reverse(-2147483648));

    // List<Character> asList = Arrays.asList('1', '2');

    // System.out.println(solution(new String[] {"test1a", "test2", "test1b", "test1c", "test3"},
    // new String[] {"asa", "ok", "test1b", "ok", "test13"}));
    System.out.println(
        solution(
            new String[] {"codility1", "codility3", "codility2", "codility4b", "codility4a"},
            new String[] {"asa", "ok", "ok", "odssds", "ok"}));
  }
}
