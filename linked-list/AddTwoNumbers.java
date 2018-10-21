/* 

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      int carry = 0;
      int value = 0;
      ListNode head = new ListNode(-1);
      ListNode current = head;
      while(l1 != null && l2 != null) {
          value = l1.val + l2.val + carry;
          if (value > 9) {
              value = value % 10;
              carry = 1;
          } else {
              carry = 0;
          }
          current.next = new ListNode(value);
          current = current.next;
          l1 = l1.next;
          l2 = l2.next;
      }
      
      while( l1 != null) {
       value = l1.val + carry;
       if (value > 9) {
          value = value % 10;
          carry = 1;
       } else {
          carry = 0;
       }
       current.next =  new ListNode(value);
       current = current.next;
       l1 = l1.next;
      }
      
      while( l2 != null) {
       value = l2.val + carry;
       if (value > 9) {
          value = value % 10;
          carry = 1;
       } else {
          carry = 0;
       }
       current.next =  new ListNode(value);
       current = current.next;
       l2 = l2.next; 
      }
      
      if (carry != 0) {
          current.next = new ListNode(carry);
      }
      
      head = head.next;
      
      return head;
      
  }
}