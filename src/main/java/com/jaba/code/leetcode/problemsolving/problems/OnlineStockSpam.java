package com.jaba.code.leetcode.problemsolving.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Augusto Baltazar (augusto.jaba@gmail.com)
 * @since 2020-05-19
 */
public class OnlineStockSpam {

  List<Integer> prices = new ArrayList<>();
  List<Integer> dp = new ArrayList<>();
  Stack<int[]> stack = new Stack<>();

  public OnlineStockSpam() {}

  public int next(final int price) {
    int span = 1;

    // While stack not empty and price gt last element's, added to the stack, price
    while (!stack.isEmpty() && price >= stack.peek()[0]) {
      span += stack.pop()[1];
    }

    stack.push(new int[] {price, span});
    return span;
  }

  /**
   * Using Table dp to store the Span for each element
   *
   * @param price
   * @return
   */
  public int nextFirstApproach(final int price) {

    if (prices.isEmpty() || price < prices.get(prices.size() - 1)) {
      dp.add(1);
    } else {
      int i = prices.size() - 1;

      while (i >= 0 && prices.get(i) <= price) {
        i -= dp.get(i);
      }
      // Hard tricky
      dp.add(prices.size() - i);
    }

    prices.add(price);
    return dp.get(dp.size() - 1);
  }

  public static void main(final String[] args) {
    final OnlineStockSpam onlineStockSpam = new OnlineStockSpam();
    System.out.println(onlineStockSpam.next(29));
    System.out.println(onlineStockSpam.next(91));
    System.out.println(onlineStockSpam.next(62));
    System.out.println(onlineStockSpam.next(76));
    System.out.println(onlineStockSpam.next(51));
  }
}
