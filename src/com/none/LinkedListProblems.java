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
}
