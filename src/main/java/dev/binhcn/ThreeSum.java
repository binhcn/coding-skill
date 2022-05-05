package dev.binhcn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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

  public static List<List> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List> res=new ArrayList<>();

    for(int i=0;i<nums.length-2;i++) {
      int lo=i+1, hi = nums.length - 1, sum = 0 - nums[i];

      if(i==0 || (i>0 && nums[i]!=nums[i-1])) {
        while(lo<hi) {
          if(nums[lo]+nums[hi]==sum) {
            res.add(Arrays.asList(nums[lo],nums[i],nums[hi]));
            while(lo<hi && nums[lo]==nums[lo+1]) lo++;
            while(hi>lo && nums[hi]==nums[hi-1]) hi--;
            lo++;
            hi--;
          }
          else if(nums[lo]+nums[hi]<sum)
            lo++;
          else
            hi--;
        }
      }
    }
    return res;
  }

  public static List<List<Integer>> find3Numbers_TwoPointer(int arr[], int sum) {
    Util.quickSort(arr, 0, arr.length - 1);
    List<List<Integer>> result = new LinkedList<>();
    for (int i = 0; i < arr.length - 2; i++) {
      if (arr[i] == arr[i+1]) continue;
      int l = i + 1;
      int r = arr.length - 1;
      while (l < r) {
        if (arr[i] + arr[l] + arr[r] == sum) {
          result.add(Arrays.asList(arr[i], arr[l], arr[r]));
          while (l < r && arr[l] == arr[l + 1]) l++;
          while (l < r && arr[r] == arr[r - 1]) r--;
          l++;
          r--;
        }
        else if (arr[i] + arr[l] + arr[r] < sum) l++;
        else r--;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int arr[] = { -1,0,1,2,-1,-4 };
    int sum = 0;

//    System.out.println(find3Numbers_TwoPointer(arr, sum));
    System.out.println(threeSum(arr));
  }
}
