package dev.binhcn;

public class RegularExpressionMatching {

  public static boolean isMatch(String s, String p) {
    int rows = s.length(), cols = p.length();
    if (rows == 0 && cols == 0) return true;
    if (cols == 0) return false;

    boolean[][] dp = new boolean[rows + 1][cols + 1];
    dp[0][0] = true;
    for (int i = 2; i < cols + 1; i++) {
      if (p.charAt(i - 1) == '*') {
        dp[0][i] = dp[0][i - 2];
      }
    }
    for (int i = 1; i < rows + 1; i++) {
      for (int j = 1; j < cols + 1; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (j > 1 && p.charAt(j - 1) == '*') {
          dp[i][j] = dp[i][j - 2];
          if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
            dp[i][j] = dp[i][j] | dp[i - 1][j];
          }
        }
      }
    }
    return dp[rows][cols];
  }

  public static void main(String[] args) {
    String[] strArr = new String[] {"aa", "aa", "ab", "aab", "mississippi"};
    String[] patternArr = new String[] {"a", "a*", ".*",  "c*a*b", "mis*is*p*."};
    for (int i = 0; i < strArr.length; i++) {
      System.out.println(isMatch(strArr[i], patternArr[i]));
    }
  }
}
