package dev.binhcn;

import java.util.Arrays;
import java.util.List;

/**
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 The overall run time complexity should be O(log (m+n)).

 Example 1:
 Input: nums1 = [1,3], nums2 = [2]
 Output: 2.00000
 Explanation: merged array = [1,2,3] and median is 2.

 https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int m = nums1.length, n = nums2.length, start = 0, end = m;
    while (start <= end) {
      int partition1 = (start + end) / 2;
      int partition2 = (m + n + 1) / 2 - partition1;
      int maxLeftNums1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
      int minRightNums1 = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];
      int maxLeftNums2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
      int minRightNums2 = partition2 == n ? Integer.MAX_VALUE : nums2[partition2];

      if (maxLeftNums1 < minRightNums2 && maxLeftNums2 < minRightNums1) {
        return (n + m) % 2 == 0
            ? (Math.max(maxLeftNums1, maxLeftNums2) + Math.min(minRightNums1, minRightNums2)) / 2.0
            : Math.max(maxLeftNums1, maxLeftNums2);
      } else if (maxLeftNums1 > minRightNums2) end = partition1 - 1;
      else start = partition1 + 1;
    }
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    List<int[]> list1 = Arrays.asList(new int[] {1,3}, new int[] {1,2,3,4,5}, new int[] {1,3,5,7});
    List<int[]> list2 = Arrays.asList(new int[] {2}, new int[] {}, new int[] {4,6,8});

    for (int i = 0; i < list1. size(); i++) {
      System.out.println(findMedianSortedArrays(list1.get(i), list2.get(i)));
    }
  }
}
