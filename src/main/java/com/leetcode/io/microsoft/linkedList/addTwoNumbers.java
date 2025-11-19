package com.leetcode.io.microsoft.linkedList;

public class addTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode(0);
        ListNode curr = head;


        while (l1 != null || l2 != null) {

            int val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if (carry) {
                val = val + 1;
                carry = false;
            }
            if (val > 9) {
                val = val % 10;
                carry = true;
            }
            curr.next = new ListNode(val);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry) curr.next = new ListNode(1);
        return head.next;
    }


}
