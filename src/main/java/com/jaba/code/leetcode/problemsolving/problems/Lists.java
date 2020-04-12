package com.jaba.code.leetcode.problemsolving.problems;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lists {

  public static void main(String[] args) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    LinkedList<Integer> linked = new LinkedList<Integer>();
    arr.add(9);
    arr.add(7);

    // linked.add

    for (int i : arr) {
      System.out.println(i);
    }

    System.out.println(arr);
  }
}
