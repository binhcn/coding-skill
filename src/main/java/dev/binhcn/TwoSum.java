package dev.binhcn;

import dev.binhcn.util.Util;
import java.util.HashMap;

/**
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 You can return the answer in any order.

 Example 1:
 Input: nums = [2,7,11,15], target = 9
 Output: [0,1]
 Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

 https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

  public static int[] twoSum_Hashmap(int[] nums, int target) {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int requiredNum = target - nums[i];
      if (hashMap.containsKey(requiredNum))
        return new int[] {hashMap.get(requiredNum), i};
      hashMap.put(nums[i], i);
    }
    return null;
  }

  public static void main(String[] args) {
    int nums[] = { 15,11,7,2 };
    int target = 9;
    Util.print(twoSum_Hashmap(nums, target));
  }
}
