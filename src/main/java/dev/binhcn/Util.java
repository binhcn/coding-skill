package dev.binhcn;

import java.util.Arrays;
import java.util.List;

public class Util {

  public static void printArr(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static int[] swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
    return a;
  }

  public static int partition(int nums[], int startIdx, int endIdx) {
   int x = nums[endIdx], i = startIdx;
   for (int j = startIdx; j < endIdx; j++) {
     if (nums[j] < x) {
       swap(nums, i, j);
       i++;
     }
   }
   swap(nums, i, endIdx);
   return i;
  }

  public static void quickSort(int nums[], int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      int pivot = partition(nums, startIdx, endIdx);
      quickSort(nums, startIdx, pivot - 1);
      quickSort(nums, pivot + 1, endIdx);
    }
  }

  public static void main(String[] args) {
    List<int[]> inputList = Arrays.asList(
        new int[] {1,8,6,2,5,4,8,3,7},
        new int[] {1,2,3,4,5},
        new int[] {3,3,7,3,5},
        new int[] {5,4,3,2,1}
    );
    for (int[] nums : inputList) {
      quickSort(nums, 0, nums.length - 1);
      printArr(nums);
    }
  }
}
