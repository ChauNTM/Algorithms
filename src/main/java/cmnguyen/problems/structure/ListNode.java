package main.java.cmnguyen.problems.structure;

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
public class ListNode {
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
