package dev.binhcn;

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
        for (int k = 0; k <result.get(j).size() + 1; k++) {
          List<Integer> currList = new ArrayList<>(result.get(j));
          currList.add(k, currValue);
          temp.add(currList);
        }
      }
      result = temp;
    }
    return result;
  }

  public static List<List<Integer>> permute1(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    permute1(result, nums, 0, nums.length - 1);
    return result;
  }

  public static void permute1(List<List<Integer>> result, int[] nums, int l, int r) {
    if (l == r) {
      List<Integer> currList = IntStream.of(nums).boxed().collect(Collectors.toList());
//      List<Integer> currList = Arrays.stream(nums).boxed().collect(Collectors.toList());
//      Integer[] currList = IntStream.of(nums).boxed().toArray(Integer[]::new);
//      Integer[] currList = Arrays.stream(nums).boxed().toArray(Integer[]::new);
      result.add(currList);
    }
    else {
      for (int i = l; i <= r; i++) {
        nums = Util.swap(nums, l, i);
        permute1(result, nums, l + 1, r);
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
      System.out.println(permute1(nums));
    }
  }
}
