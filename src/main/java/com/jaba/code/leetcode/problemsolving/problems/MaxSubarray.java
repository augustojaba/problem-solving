package com.jaba.code.leetcode.problemsolving.problems;

public class MaxSubarray {

    public int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int left = 0;  left < nums.length; left++) {

            int currentSum = 0;

            for (int right = left; right < nums.length; right++) {
                currentSum += nums[right];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = left;
                    end = right;
                }

            }
        }

        return maxSum;

    }
}
