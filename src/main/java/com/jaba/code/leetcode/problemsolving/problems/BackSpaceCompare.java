package com.jaba.code.leetcode.problemsolving.problems;

public class BackSpaceCompare {

    public static void main(String[] args) {
        System.out.println(BackSpaceCompare.backspaceCompare("a#c", "b"));
    }

    private static boolean backspaceCompare(String S, String T) {

        int sIndex = 0, tIndex = 0;

        while (sIndex < S.length() || tIndex < T.length()) {
            if (sIndex < S.length() && '#' == S.charAt(sIndex)) {
                String prefix = "";
                if (sIndex > 0) prefix = S.substring(0, sIndex - 1);
                S = prefix + S.substring(sIndex + 1);
                if (sIndex > 0) sIndex--;
            } else sIndex++;

            if (tIndex < T.length() && '#' == T.charAt(tIndex)) {
                String prefix = "";
                if (tIndex > 0) prefix = T.substring(0, tIndex - 1);
                T = prefix + T.substring(tIndex + 1);
                if (tIndex > 0) tIndex--;
            } else tIndex++;
    }

    return S.equals(T);
  }
}
