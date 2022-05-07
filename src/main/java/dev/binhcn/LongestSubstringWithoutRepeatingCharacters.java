package dev.binhcn;

import java.util.HashSet;
import java.util.Set;

/**
 Given a string s, find the length of the longest substring without repeating characters.
 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {

  public static int lengthOfLongestSubstring(String s) {
    if (s == null || s.equals("")) {
      return 0;
    }
    int start = 0, end = 0, maxLength = 0;
    Set<Character> hashSet = new HashSet<>();
    while (end < s.length()) {
      if (hashSet.add(s.charAt(end))) {
        end++;
        maxLength = Math.max(maxLength, hashSet.size());
      } else {
        hashSet.remove(s.charAt(start));
        start++;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    String[] strArr = new String[] {"abcabcbb", "bbbbb", "pwwkew"};
    for (String str : strArr) {
      System.out.println(lengthOfLongestSubstring(str));
    }
  }
}
