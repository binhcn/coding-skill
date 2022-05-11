package dev.binhcn;

import dev.binhcn.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 Example 1:
 Input: nums = [1,2,3]
 Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 https://leetcode.com/problems/permutations/
 */
public class Permutations {
  
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList());
    for (int i = 0; i < nums.length; i++) {
      int currValue = nums[i];
      List<List<Integer>> temp = new ArrayList<>();
      for (int j = 0; j < result.size(); j++) {
        for (int k = 0; k <= result.get(j).size(); k++) {
          List<Integer> currList = new ArrayList<>(result.get(j));
          currList.add(k, currValue);
          temp.add(currList);
        }
      }
      result = temp;
    }
    return result;
  }

  public static List<List<Integer>> permute_recursive(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute_recursive(result, nums, 0, nums.length - 1);
    return result;
  }

  public static void permute_recursive(List<List<Integer>> result, int[] nums, int l, int r) {
    if (l == r) {
      List<Integer> currList = IntStream.of(nums).boxed().collect(Collectors.toList());
      result.add(currList);
    }
    else {
      for (int i = l; i <= r; i++) {
        nums = Util.swap(nums, l, i);
        permute_recursive(result, nums, l + 1, r);
        nums = Util.swap(nums, l, i);
      }
    }
  }

  public static void main(String[] args) {
    List<int[]> inputList = Arrays.asList(
        new int[] {1,2,3},
        new int[] {1}
    );
    for (int[] nums : inputList) {
      System.out.println(permute(nums));
    }
  }
}
