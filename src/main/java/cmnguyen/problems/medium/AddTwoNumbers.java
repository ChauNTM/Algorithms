package main.java.cmnguyen.problems.medium;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(){}

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            StringBuilder str = new StringBuilder("[");
            str.append(val);
            ListNode x = this.next;
            while (x != null) {
                str.append(", ").append(x.val);
                x = x.next;
            }
            return str + "]";
        }
    }

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
