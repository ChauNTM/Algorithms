package main.java.cmnguyen.problems.medium;

import main.java.cmnguyen.problems.structure.ListNode;

public class SplitLinkedListInParts {

    public static ListNode[] splitListToParts(ListNode head, int k) {
        if (k == 0) return new ListNode[]{head};
        int n = 0;
        for (ListNode x = head; x != null; x = x.next) n++;

        int length = n / k;
        int index = n % k;
        ListNode[] result = new ListNode[k];
        for (int i = 0; i < k && head != null; i++, index--) {
            result[i] = head;
            ListNode pre = head;
            for (int j = 0; j < length + (index > 0 ? 1 : 0); j++) {
                pre = head;
                head = head.next;
            }
            pre.next = null;
        }
        return result;
    }
}
