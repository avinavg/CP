package com.leetcode.io.microsoft.linkedList;

import java.util.HashMap;
import java.util.Map;

public class RandomPointer {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {

        Node dummyStart = new Node(0);
        Node curr = dummyStart;

        Node headIter = head;
        Map<Node, Node> originalNewNodeMap = new HashMap<>();

        while (headIter != null) {
            Node nextNode = new Node(headIter.val);
            originalNewNodeMap.put(headIter, nextNode);
            nextNode.next = headIter.next;
            headIter = headIter.next;
            curr.next = nextNode;
            curr = curr.next;
        }
        headIter = head;
        curr = dummyStart.next;
        while (headIter != null) {
            curr.random = originalNewNodeMap.get(headIter.random);
            curr = curr.next;
            headIter = headIter.next;
        }
        return dummyStart.next;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
