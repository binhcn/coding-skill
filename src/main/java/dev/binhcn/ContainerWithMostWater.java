package dev.binhcn;

import java.util.Arrays;
import java.util.List;

/**
 You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 Find two lines that together with the x-axis form a container, such that the container contains the most water.
 Return the maximum amount of water a container can store.
 Notice that you may not slant the container.

 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49
 Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

 Time complexity : O(n^2) equilvalent O[n(n-1)/2]
 Time complexity : O(n)

 https://leetcode.com/problems/container-with-most-water/solution/
 */
public class ContainerWithMostWater {

  //Two Pointer Approach
  public static int maxArea(int[] height) {
    int maxArea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) l++;
      else r--;
    }
    return maxArea;
  }

  public static void main(String[] args) {
    List<int[]> inputList = Arrays.asList(
        new int[] {1,8,6,2,5,4,8,3,7},
        new int[] {1,2,3,4,5}
    );
    for (int[] number : inputList) {
      System.out.println(maxArea(number));
    }
  }
}
