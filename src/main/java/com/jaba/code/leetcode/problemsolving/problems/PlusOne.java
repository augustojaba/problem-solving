package com.jaba.code.leetcode.problemsolving.problems;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-06-02
 */
public class PlusOne {

  public int[] plusOne(int[] digits) {

    final int digitsLength = digits.length;

    for (int i = digitsLength - 1; i >= 0; i--) {

      if (i > 0) {

        if (digits[i] == 9) {
          digits[i] = 0;
        } else {
          digits[i]++;
          break;
        }

      } else {

        if (digits[i] == 9) {
          digits[i] = 0;
          final int[] aux = new int[digitsLength + 1];
          aux[0] = 1;
          for (int j = 1; j < aux.length; j++) {
            aux[j] = digits[j - 1];
          }
          digits = aux;

        } else {
          digits[i]++;
          break;
        }
      }
    }

    return digits;
  }
}
