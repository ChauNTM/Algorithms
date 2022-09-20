package main.java.cmnguyen.problems.medium.two_pointers;

import main.java.cmnguyen.problems.structure.ListNode;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int n = 1;
        ListNode tail;
        for (tail = head; tail.next != null; tail = tail.next) n++;
        int startIndex = n - (k % n);
        int i = 1;
        ListNode start = head;
        while(i < startIndex) {
            start = start.next;
            i++;
        }
        tail.next = head;
        head = start.next;
        start.next = null;
        return head;
    }
}
