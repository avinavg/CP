package com.leetcode.io.microsoft.linkedList;

public class MergeList {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pointerHead = new ListNode();
        ListNode curr = pointerHead;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l1;
                curr.next.next = l2;
                l2 = l2.next;
                l1 = l1.next;
                curr = curr.next;
            }
            curr = curr.next;
        }
        if (l1 == null) {
            curr.next = l2;
        } else {
            curr.next = l1;
        }
        return pointerHead.next;
    }
}
