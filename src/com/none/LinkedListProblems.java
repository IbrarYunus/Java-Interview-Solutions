package com.none;

import java.util.HashSet;

public class LinkedListProblems {

    public void removeDuplicates(LinkedListNode n) {
        System.out.println("Removing duplicates");
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;

        while(n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    public LinkedListNode KthToLastElement(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i = 0; i < k; i++) {
            if(p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 !=null){
            p1 = p1.next;
            p2 = p2.next;
        }

        System.out.println("\nKth element: " + p2.data);
        return null;
    }

    public LinkedListNode deleteMiddleNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return null;
        }

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return null;
    }
}
