package dev.binhcn.util;

public class LinkedList {

  public Node head;

  public LinkedList(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      this.append(nums[i]);
    }
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      return;
    }
    Node temp = head;
    while (temp.next != null) temp = temp.next;
    temp.next = newNode;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    LinkedList linkedList = new LinkedList(nums);
    Util.print(linkedList);
  }
}
