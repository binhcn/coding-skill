package dev.binhcn;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target)
          return new int[] {i, j};
      }
    }
    return new int[] {};
  }

  public static int[] twoSum_TwoPointer(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    Util.quickSort(nums, left, right);
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        return new int[] {left, right};
      } else if (sum < target) left++;
      else right--;
    }
    return new int[] {};
  }

  public static void main(String[] args) {
    int nums[] = { 15,11,7,2 };
    int target = 9;
    Util.printArr(twoSum_TwoPointer(nums, target));
  }
}
