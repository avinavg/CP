package com.leetcode.io.microsoft.linkedList;

public class CycledLL {


    public static void main(String[] args) {
        System.out.println(hasCycle(new ListNode(1)));
    }


    public static boolean hasCycle(ListNode head) {
        ListNode fp = head;
        ListNode sp = head;
        while (fp != null && fp.next != null) {
            sp = sp.next;
            fp = fp.next.next;
            if (fp == sp) {
                return true;
            }
        }
        return false;
    }
}
