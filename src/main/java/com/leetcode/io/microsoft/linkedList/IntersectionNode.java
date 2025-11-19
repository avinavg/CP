package com.leetcode.io.microsoft.linkedList;

public class IntersectionNode {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode startingNode = lengthA > lengthB ? headA : headB;
        for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
            startingNode = startingNode.next;
        }
        ListNode trailingNode = lengthA > lengthB ? headB : headA;

        while (startingNode != trailingNode && startingNode != null) {
            startingNode = startingNode.next;
            trailingNode = trailingNode.next;
        }
        return startingNode;
    }

    public int getLength(ListNode headA) {
        int length = 0;
        while (headA != null) {
            headA = headA.next;
            length++;
        }
        return length;
    }


}
