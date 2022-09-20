package main.java.cmnguyen.problems.medium;

import main.java.cmnguyen.problems.structure.ListNode;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head, even = head.next;
        for (; odd.next != null && even.next != null; odd = odd.next, even = even.next) {
            odd.next = even.next;
            even.next = odd.next.next;
        }
        odd.next = evenHead;
        return head;
    }
}
