package main.java.cmnguyen.problems.medium;

import main.java.cmnguyen.problems.structure.ListNode;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int value = 0;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (l1 != null) {
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value2 = l2.val;
                l2 = l2.next;
            }

            value = value + value1 + value2;
            tail.next = new ListNode(value % 10);
            tail = tail.next;
            value = value / 10;
        }
        if (value > 0) {
            tail.next = new ListNode(value);
        }
        // Note: this uses a little magic here, return dummy.next instead of dummy
        return dummy.next;
    }
}
