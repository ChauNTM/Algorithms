package main.java.cmnguyen.problems.medium.two_pointers;

import main.java.cmnguyen.problems.structure.ListNode;

public class DeleteMiddle {

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
