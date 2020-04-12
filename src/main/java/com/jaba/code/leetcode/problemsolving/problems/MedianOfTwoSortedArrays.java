package com.jaba.code.leetcode.problemsolving.problems;

public class MedianOfTwoSortedArrays {

  public static void main(String[] args) {
    MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

    // System.out.println(solution.solutionBruteForce(new int[] {1, 2}, new int[] {3, 4}));
    System.out.println(solution.solutionBinarySearch(new int[] {}, new int[] {}));
  }

  public double solutionBinarySearch(int[] nums1, int[] nums2) {
    int[] x, y;

    if (nums1.length + nums2.length == 0) {
      throw new IllegalArgumentException();
    }

    if (nums1.length < nums2.length) {
      x = nums1;
      y = nums2;
    } else {
      y = nums1;
      x = nums2;
    }

    int low = 0;
    int high = x.length;

    while (low <= high) {
      int partitionX = (low + high) / 2;
      int partitionY = ((x.length + y.length + 1) / 2) - partitionX;

      int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : x[partitionX - 1];
      int minRightX = partitionX == x.length ? Integer.MAX_VALUE : x[partitionX];

      int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : y[partitionY - 1];
      int minRightY = partitionY == y.length ? Integer.MAX_VALUE : y[partitionY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {

        if ((x.length + y.length) % 2 == 0) {
          return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        high = partitionX - 1;

      } else {
        low = partitionX + 1;
      }
    }

    throw new IllegalArgumentException();
  }

  public double solutionBruteForce(int[] nums1, int[] nums2) {

    int[] aux = new int[nums1.length + nums2.length];

    if (nums1.length == 0 && nums2.length == 0) {
      return 0d;
    } else if (nums1.length == 0 && nums2.length != 0) {
      aux = nums2;
    } else if (nums1.length != 0 && nums2.length == 0) {
      aux = nums1;
    } else {
      int p1 = 0;
      int p2 = 0;

      for (int i = 0; i < aux.length; i++) {
        if (p2 >= nums2.length || (p1 < nums1.length && nums1[p1] <= nums2[p2])) {
          aux[i] = nums1[p1];
          p1++;
        } else {
          aux[i] = nums2[p2];
          p2++;
        }
      }
    }
    for (int i = 0; i < aux.length; i++) {
      System.out.println(aux[i]);
    }

    if (aux.length % 2 == 0) {
      return (aux[(aux.length / 2) - 1] + aux[aux.length / 2]) / 2.0;
    } else {
      return aux[(aux.length - 1) / 2];
    }
  }
}
