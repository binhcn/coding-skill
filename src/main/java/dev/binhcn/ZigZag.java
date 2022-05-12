package dev.binhcn;

/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);


 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:
 P     I    N
 A   L S  I G
 Y A   H R
 P     I

 https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigZag {

  public static String convert_(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    int modulus = numRows * 2 - 2;
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < s.length(); j++) {
        if (j % modulus == i || j % modulus == modulus - i) {
          sb.append(s.charAt(j));
        }
      }
    }
    return sb.toString();
  }

  //Time complexity: O(n)
  public static String convert(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    int modulus = numRows * 2 - 2;
    for (int i = 0; i < numRows; i++) {
      for (int j = i; j < s.length(); j += modulus) {
        sb.append(s.charAt(j));
        int k = j + modulus - 2 * i;
        if (i > 0 && i < numRows - 1 && k < s.length()) {
          sb.append(s.charAt(k));
        }
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "PAYPALISHIRING";
    System.out.println(convert(str, 3));
    System.out.println(convert(str, 3).equalsIgnoreCase("PAHNAPLSIIGYIR"));
    System.out.println(convert(str, 4));
    System.out.println(convert(str, 4).equalsIgnoreCase("PINALSIGYAHRPI"));
  }
}
