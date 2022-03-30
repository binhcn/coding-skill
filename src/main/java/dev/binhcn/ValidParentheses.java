package dev.binhcn;

import java.util.Stack;

/**
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 An input string is valid if:

 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.

 https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(')');
      } else if (s.charAt(i) == '{') {
        stack.push('}');
      } else if (s.charAt(i) == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s1 = "([]{})";
    String s2 = "({[])}";
    System.out.println(isValid(s1));
    System.out.println(isValid(s2));
  }
}
