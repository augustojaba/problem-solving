package com.jaba.code.leetcode.problemsolving.problems.dynamicprogramming;

public class Fibonacci {

    private long[] fiboMemo;

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fiboDPMemo(50));
    }

    private static int fibo(int n) {
        if (n <= 1) return n;

        return fibo(n - 1) + fibo(n - 2);
    }

    private long fiboDPMemo(int n) {

        if (fiboMemo == null) fiboMemo = new long[n + 1];

        if (n <= 1) fiboMemo[n] = n;
        else fiboMemo[n] = fiboDPMemo(n - 1) + fiboDPMemo(n - 2);

        return fiboMemo[n];
    }
}
