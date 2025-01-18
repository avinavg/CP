package com.leetcode.io.problems;

public class Leetcode2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));


        ListNode result = addTwoNumbers(l1, l2);

        printList(result);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode tempNode = head;
        int nextVal;
        boolean addOver = false;
        int v1;
        int v2;

        while (l1 != null || l2 != null) {
            v1 = l1 == null ? 0 : l1.val;
            v2 = l2 == null ? 0 : l2.val;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            nextVal = addOver ? v1 + v2 + 1 : v1 + v2;
            addOver = nextVal > 9;
            nextVal = addOver ? nextVal - 10 : nextVal;
            tempNode.next = new ListNode(nextVal);
            tempNode = tempNode.next;

        }
        if (addOver) {
            tempNode.next = new ListNode(1);
        }
        return head.next;
    }
}
