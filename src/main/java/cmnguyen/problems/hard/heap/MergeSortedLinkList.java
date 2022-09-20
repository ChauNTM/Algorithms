package main.java.cmnguyen.problems.hard.heap;

import main.java.cmnguyen.problems.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeSortedLinkList {

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));
        ListNode result = null;
        ListNode dummy = new ListNode(0);

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) minHeap.add(lists[i]);
        }

        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            if (result == null) {
                result = new ListNode(min.val);
                dummy.next = result;
            } else {
                result.next = new ListNode(min.val);
                result = result.next;
            }
            if (min.next != null) minHeap.add(min.next);
        }

        return dummy.next;
    }
}
