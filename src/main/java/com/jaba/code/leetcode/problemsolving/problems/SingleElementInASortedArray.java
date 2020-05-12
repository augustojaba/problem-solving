package com.jaba.code.leetcode.problemsolving.problems;

public class SingleElementInASortedArray {
  public int singleNonDuplicate(final int[] nums) {

    if (nums.length == 1) {
      return nums[0];
    }

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

      // par

      final int mid = left + (right - left) / 2;

      if ((mid == 0 && nums[mid] != nums[mid + 1])
          || (mid == nums.length - 1 && nums[mid] != nums[mid - 1])
          || (mid > 0
              && mid < nums.length - 2
              && nums[mid] != nums[mid - 1]
              && nums[mid] != nums[mid + 1])) {
        return nums[mid];
      }

      if (mid % 2 == 0) {
        if (nums[mid] == nums[mid - 1]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] != nums[mid + 1]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return nums[left];
  }
}
