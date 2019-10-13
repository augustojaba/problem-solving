package com.jaba.code.leetcode.problemsolving.problems.dynamicprogramming;

public class Fibonacci {

    int[] fiboMemo;

    private int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        return fibo(n-1) + fibo(n-2);
    }

    private int fiboDPMemo(int n) {

        if (this.fiboMemo == null) {
            fiboMemo = new int[n + 1];
        }

        if (n <= 1) {
            fiboMemo[n] = n;
        } else {
            fiboMemo[n] = fiboDPMemo(n - 1) + fiboDPMemo(n - 2);
        }

        return fiboMemo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fiboDPMemo(50));
    }
}
