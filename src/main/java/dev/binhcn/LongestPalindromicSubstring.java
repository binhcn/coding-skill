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
    String updatedStr = getUpdatedString(s);
    int c = 0, r = 0, offset = 0, position = -1, length = updatedStr.length();
    int[] p = new int[length];
    for (int i = 0; i < length; i++) {
      if (i < r) {
        int mirror = 2 * c - i;
        p[i] = Math.min(r - i, p[mirror]);
      }
      int a = i + (1 + p[i]), b = i - (1 + p[i]);
      while (a < length && b > -1 && updatedStr.charAt(a) == updatedStr.charAt(b)) {
        p[i]++;
        a++;
        b--;
      }
      if (i + p[i] > r) {
        c = i;
        r = i + p[i];
      }
      if (offset < p[i]) {
        offset = p[i];
        position = i;
      }
    }
    StringBuilder result = new StringBuilder();
    for (int i = position - offset + 1; i <= position + offset - 1; i++) {
      if (updatedStr.charAt(i) != '#') {
        result.append(updatedStr.charAt(i));
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
