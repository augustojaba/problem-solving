package com.jaba.code.leetcode.problemsolving.problems;

public class BitwiseAndOfNumberRange {

  public int calculateMSBPos(int n) {
    int pos = -1;

    while (n > 0) {
      n = n >> 1;
      pos++;
    }

    return pos;
  }

  public int rangeBitwiseAnd(int m, int n) {

    int result = 0;

    while (m > 0 && n > 0) {
      int mMSBp = calculateMSBPos(m);
      int nMSBp = calculateMSBPos(n);
      if (mMSBp != nMSBp) {
        break;
      } else {
        int msb = ((Double) (Math.pow(2, mMSBp))).intValue();
        result += msb;
        m = m - msb;
        n = n - msb;
      }
    }
    return result;
  }

  public static void main(String[] args) {

    System.out.println(new BitwiseAndOfNumberRange().rangeBitwiseAnd(17, 19));
  }
}
