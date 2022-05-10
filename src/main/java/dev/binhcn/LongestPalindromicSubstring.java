package dev.binhcn;

/**
 Given a string s, return the longest palindromic substring in s.
 Example 1:
 Input: s = "babad"
 Output: "bab"
 Explanation: "aba" is also a valid answer.

 Example 2:
 Input: s = "cbbd"
 Output: "bb"
 https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

  public static String longestPalindrome(String s) {
    String updatedString = getUpdatedString(s);
    int length = 2 * s.length() + 1;
    int[] p = new int[length];
    int c = 0, r = 0, maxLength = 0, position = -1;
    for (int i = 0; i < length; i++) {
      if (i < r) {
        int mirror = 2 * c - i;
        p[i] = Math.min(r - i, p[mirror]);
      }
      int a = i + (1 + p[i]);
      int b = i - (1 + p[i]);
      while (a < length && b >= 0 && updatedString.charAt(a) == updatedString.charAt(b)) {
        p[i]++;
        a++;
        b--;
      }
      if (i + p[i] > r) {
        c = i;
        r = i + p[i];
      }
      if (maxLength < p[i]) {
        maxLength = p[i];
        position = i;
      }
    }
    int offset = p[position];
    StringBuilder result = new StringBuilder();
    for (int i = position - offset + 1; i <= position + offset - 1; i++) {
      if (updatedString.charAt(i) != '#') {
        result.append(updatedString.charAt(i));
      }
    }
    return result.toString();
  }

  private static String getUpdatedString(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      sb.append("#").append(s.charAt(i));
    }
    sb.append("#");
    return sb.toString();
  }

  public static void main(String[] args) {
    String[] strArr = new String[] {"ababac", "cbbd"};
    for (String str : strArr) {
      System.out.println(longestPalindrome(str));
    }
  }
}
