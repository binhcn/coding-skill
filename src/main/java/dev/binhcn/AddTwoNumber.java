package dev.binhcn;

import dev.binhcn.util.LinkedList;
import dev.binhcn.util.Node;
import dev.binhcn.util.Util;

/**
 You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order, and each of their nodes contains a single digit.
 Add the two numbers and return the sum as a linked list.
 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Example 1:
 Input: l1 = [2,4,3], l2 = [5,6,4]
 Output: [7,0,8]
 Explanation: 342 + 465 = 807.

 https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumber {

  public static Node addTwoNumbers(Node l1, Node l2) {
    Node head = null, temp = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      int sum = carry;
      if (l1 != null) {
        sum += l1.data;
        l1 = l1.next;
      }
      if (l2 != null) {
        sum += l2.data;
        l2 = l2.next;
      }
      Node node = new Node(sum % 10);
      carry = sum / 10;
      if (temp == null) head = temp = node;
      else {
        temp.next = node;
        temp = temp.next;
      }
    }
    temp.next = carry > 0 ? new Node(carry) : null;
    return head;
  }

  public static void main(String[] args) {
    LinkedList linkedList1 = new LinkedList(new int[] {2,4,3});
    LinkedList linkedList2 = new LinkedList(new int[] {5,6,4});
    Util.print(addTwoNumbers(linkedList1.head, linkedList2.head));
  }

}
