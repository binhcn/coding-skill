package dev.binhcn;

/**
 Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes
 the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 Input: x = 123
 Output: 321
 Example 2:

 Input: x = -123
 Output: -321
 Example 3:

 Input: x = 120
 Output: 21

 https://leetcode.com/problems/reverse-integer/
 */
public class ReverseInteger {

  public static int reverse(int x) {
    int revertedNum = 0;
    while (x != 0) {
      revertedNum = revertedNum * 10 + x % 10;
      x /= 10;
    }
    return revertedNum;
  }

  public static void main(String[] args) {
    int[] nums = new int[] {123, -123, 120};
    for (int num : nums) {
      System.out.println(reverse(num));
    }
  }
}
