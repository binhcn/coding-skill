package dev.binhcn;

/**
 Given an integer x, return true if x is palindrome integer.
 An integer is a palindrome when it reads the same backward as forward.
 For example, 121 is a palindrome while 123 is not.

 https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

  //Revert half of the number
  public static boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int revertedNumber = 0;
    while (x > revertedNumber) {
      revertedNumber = revertedNumber * 10 + x % 10;
      x /= 10;
    }
    return x == revertedNumber || x == revertedNumber / 10;
  }

  public static void main(String[] args) {
    int[] inputArr = new int[] {-121, 12321, 1221, 1223, 123};
    for (int number : inputArr) {
      System.out.println(isPalindrome(number));
    }
  }
}
