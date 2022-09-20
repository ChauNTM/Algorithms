package main.java.cmnguyen.problems.medium.two_pointers;

import main.java.cmnguyen.problems.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * */
public class RemoveNthNode {
    /**
     * Using hash map uses too much memory, we need to keep pointer to node which is previous to current node that we
     * want to delete, So using 2 pointers will save much memory.
     * */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int i = 1;
        while(node != null) {
            map.put(i, node);
            i++;
            node = node.next;
        }
        i--;
        // remove node
        ListNode previous = map.get(i - n);
        ListNode remove = map.get(i - n + 1);
        if (previous == null && remove != null) {// remove head
            if (head.next != null) {
                head = head.next;
            }
            else head = null;
        } else if (remove == null) {// remove tail
            return head;
        } else {
            previous.next = remove.next;
            remove.next = null;
        }
        return head;
    }

    public static ListNode removeNthFromEnd2Pointers(ListNode head, int n) {
        if (head == null) return head;
        ListNode current = head;
        ListNode temp = head;

        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        while(current != null && current.next != null) {
            temp = temp.next;
            current = current.next;
        }

        if (current == null) {
            head = head.next;
        } else {
            temp.next = temp.next.next;
        }

        return head;
    }
}
