package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.ListNode;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private static ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseList(next, head);
    }

}
