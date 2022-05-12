package dev.binhcn;

public class Atoi {

  private static int atoi(String str) {
    if (str == null || str.isEmpty()) return 0;
    str = str.replaceAll("^\\s+", "");
    int i = 0;
    boolean isNegative = str.startsWith("-");
    boolean isPositive = str.startsWith("+");
    if (isNegative || isPositive) i++;

    double number = 0;
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      number = number * 10 + (str.charAt(i) - '0');
      i++;
    }
    number = isNegative ? -number : number;
    number = number < Integer.MIN_VALUE ? Integer.MIN_VALUE : number;
    number = number > Integer.MAX_VALUE ? Integer.MAX_VALUE : number;
    return (int)number;
  }

  public static void main(String[] args) {
    String[] strArr = new String[] {"42", "   -42", "4193 with words", "words and 987", "-91283472332"};
    for (String str : strArr) {
      System.out.println(atoi(str));
    }
  }
}
