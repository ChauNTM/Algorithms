package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.ListNode;

public class MiddleOfLinkedList {

    public static ListNode middleNode(ListNode head) {
        if (head == null) return head;
        int count = 1;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null) {
            fast = fast.next;
            count++;
            if (count % 2 == 0) {
                slow = slow.next;
            }
        }

        return slow;
    }
}
