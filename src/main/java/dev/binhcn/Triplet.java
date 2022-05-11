package dev.binhcn;

import dev.binhcn.util.Util;
import java.util.HashSet;

/**
 Given an array and a value, find if there is a triplet in array whose sum is equal to the given value.
 If there is such a triplet present in array, then print the triplet and return true. Else return false.
 Input: array = {12, 3, 4, 1, 6, 9}, sum = 24;
 Output: 12, 3, 9
 Explanation: There is a triplet (12, 3 and 9) present
 in the array whose sum is 24.

 https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class Triplet {

  public static boolean find3Numbers_HashSet(int nums[], int sum) {
    for (int i = 0; i < nums.length - 2; i++) {
      HashSet<Integer> hashSet = new HashSet<>();
      int currSum = sum - nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        if (hashSet.contains(currSum - nums[j])) {
          System.out.printf("Triplet is %d, %d, %d", nums[i], nums[j], currSum - nums[j]);
          return true;
        }
        hashSet.add(nums[j]);
      }
    }
    return false;
  }

  public static boolean find3Numbers_TwoPointer(int nums[], int sum) {
    Util.quickSort(nums, 0, nums.length - 1);
    for (int i = 0; i < nums.length - 2; i++) {
      int l = i + 1, r = nums.length - 1, target = sum - nums[i];
      while (l < r) {
        if (nums[l] + nums[r] == target) {
          System.out.print("Triplet is " + nums[i] + ", " + nums[l] + ", " + nums[r]);
          return true;
        }
        else if (nums[l] + nums[r] < target) l++;
        else r--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int nums[] = { 1, 4, 45, 6, 10, 8 };
    int sum = 22;

    find3Numbers_HashSet(nums, sum);
    System.out.println();
    find3Numbers_TwoPointer(nums, sum);
  }
}
