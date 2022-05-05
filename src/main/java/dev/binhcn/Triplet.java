package dev.binhcn;

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

  public static boolean find3Numbers_HashSet(int arr[], int sum) {
    for (int i = 0; i < arr.length - 2; i++) {
      HashSet<Integer> hashSet = new HashSet<>();
      int currSum = sum - arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (hashSet.contains(currSum - arr[j])) {
          System.out.printf("Triplet is %d, %d, %d", arr[i], arr[j], currSum - arr[j]);
          return true;
        }
        hashSet.add(arr[j]);
      }
    }
    return false;
  }

  public static boolean find3Numbers_TwoPointer(int arr[], int sum) {
    Util.quickSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length - 2; i++) {
      int l = i + 1;
      int r = arr.length - 1;
      while (l < r) {
        if (arr[i] + arr[l] + arr[r] == sum) {
          System.out.print("Triplet is " + arr[i] + ", " + arr[l] + ", " + arr[r]);
          return true;
        }
        else if (arr[i] + arr[l] + arr[r] < sum) l++;
        else r--;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 4, 45, 6, 10, 8 };
    int sum = 22;

//    find3Numbers_HashSet(arr, sum);
    find3Numbers_TwoPointer(arr, sum);
  }
}
