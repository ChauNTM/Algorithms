package main.java.cmnguyen.problems.medium;

public class MinStack {
    private Node head;
    private int n;
    private Node min;

    public static class Node {
        int value;
        Node next;

        public Node(int val) {
            this.value = val;
            next = null;
        }
    }

    public MinStack() {
        n = 0;
        head = null;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        n++;

        if (min == null) {
            min = new Node(val);
        } else if (val <= min.value) {
            Node newMin = new Node(val);
            newMin.next = min;
            min = newMin;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            if (top() == min.value) {
                min = min.next;
            }
            head = head.next;
            n--;
        }
    }

    public int top() {
        if (!isEmpty()) {
            return head.value;
        }
        return 0;
    }

    public int getMin() {
        if (!isEmpty()) return min.value;
        return 0;
    }
}
