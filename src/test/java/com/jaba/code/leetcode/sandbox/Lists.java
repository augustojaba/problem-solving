package com.jaba.code.leetcode.sandbox;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {

  public static void main(final String[] args) {
    final ArrayList<Integer> arr = new ArrayList<>();
    final LinkedList<Integer> linked = new LinkedList<>();
    arr.add(9);
    arr.add(7);

    // linked.add

    for (final int i : arr) {
      System.out.println(i);
    }

    System.out.println(arr);
  }
}
