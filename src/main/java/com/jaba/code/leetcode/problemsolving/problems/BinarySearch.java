package com.jaba.code.leetcode.problemsolving.problems;

import java.io.Reader;
import java.util.Arrays;

public class BinarySearch {

    static boolean exists(int[] ints, int k) {

        if (ints[0] > k || ints[ints.length -1] < k) { return false;}

        if (ints.length == 0) {
            return false;
        }

        int min = 0;
        int max = ints.length;
        int mid = (max - min)/2;

        while (mid > 0 || mid < ints.length) {
            if (ints[mid] == k) {
                return true;
            }

            if (ints[mid] < k) {
                min = mid;
            } else {
                max = mid;
            }

            mid = (max + min)/2;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.exists(new int[] {-9, 14, 37, 102}, 4));
    }
}
