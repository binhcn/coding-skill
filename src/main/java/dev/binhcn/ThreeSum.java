package dev.binhcn;

import dev.binhcn.util.Util;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

 Notice that the solution set must not contain duplicate triplets.

 Input: nums = [-1,0,1,2,-1,-4]
 Output: [[-1,-1,2],[-1,0,1]]
 https://leetcode.com/problems/3sum/
 */
public class ThreeSum {

  public static List<List<Integer>> threeSum(int nums[], int sum) {
    Util.quickSort(nums, 0, nums.length - 1);
    List<List<Integer>> result = new LinkedList<>();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i-1] == nums[i]) continue;
      int l = i + 1, r = nums.length - 1, target = sum - nums[i];
      while (l < r) {
        if (nums[l] + nums[r] == target) {
          result.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[l + 1]) l++;
          while (l < r && nums[r] == nums[r - 1]) r--;
          l++;
          r--;
        }
        else if (nums[l] + nums[r] < target) l++;
        else r--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int nums[] = { -1,0,1,2,-1,-4 };
    int sum = 0;
    System.out.println(threeSum(nums, sum));
  }
}
