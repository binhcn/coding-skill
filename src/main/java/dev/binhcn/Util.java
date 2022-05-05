package dev.binhcn;

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

  public static int partition(int arr[], int startIdx, int endIdx) {
    int x = arr[endIdx];
    int i = startIdx;
    for (int j = startIdx; j < endIdx; j++) {
      if (arr[j] <= x) {
        Util.swap(arr, i, j);
        i++;
      }
    }
    Util.swap(arr, i, endIdx);
    return i;
  }

  public static void quickSort(int arr[], int startIdx, int endIdx) {
    if (startIdx < endIdx) {
      int pivot = partition(arr, startIdx, endIdx);
      quickSort(arr, startIdx, pivot - 1);
      quickSort(arr, pivot + 1, endIdx);
    }
  }

  public static void main(String[] args) {
    int[] nums = {3,3,3,5};
    quickSort(nums, 0, nums.length - 1);
    printArr(nums);
  }
}
