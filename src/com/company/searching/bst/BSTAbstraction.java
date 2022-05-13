package com.company.searching.bst;

import java.util.LinkedList;
import java.util.Queue;

public abstract class BSTAbstraction <Key extends Comparable<Key>, Value> {

    protected final boolean RED = true;
    protected final boolean BLACK = false;
    class Node {
        protected Key key;
        protected Value value;
        protected int N;

        protected Node left;
        protected Node right;

        protected boolean color;
        public Node(Key key, Value val, boolean color) {
            this(key, val);
            this.color = color;
        }

        public Node(Key key, Value val) {
            this.key = key;
            this.value = val;
            this.N = 1;
            this.color = BLACK;
        }
    }
    Node root;

    public abstract void deleteMin();
    public abstract void put(Key key, Value value);

    public int size(Node h) {
        if (h == null) return 0;
        return h.N;
    }

    Value get(Key key) {
        Node x = get(root, key);
        if (x == null) return null;
        return x.value;
    }

    Node get(Node h, Key key) {
        if (h == null) return null;

        int compare = key.compareTo(h.key);
        if (compare < 0) return get(h.left, key);
        else if (compare > 0) return get(h.right, key);
        else return h;
    }



    public Key min() {
        Node min = min(root);
        if (min == null) return null;
        return min.key;
    }

    protected Node min(Node h) {
        if (h == null) return null;
        if (h.left == null) return h;
        return min(h.left);
    }

    public Key max() {
        return max(root);
    }

    protected Key max(Node h) {
        if (h == null) return null;
        if (h.right == null) return h.key;
        return max(h.right);
    }

    public Queue<Key> keys() {
        return keys(min(), max());
    }

    public Queue<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(queue, root, lo, hi);
        return queue;
    }

    void keys(Queue<Key> queue, Node h, Key lo, Key hi) {
        if (h == null) return;
        int cmpLo = lo.compareTo(h.key);
        int cmpHi = hi.compareTo(h.key);

        if (cmpLo < 0) keys(queue, h.left, lo, hi);
        if (cmpLo <= 0 && cmpHi >= 0) queue.add(h.key);
        if (cmpHi > 0) keys(queue, h.right, lo, hi);
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    int rank(Node h, Key key) {
        if (h == null) return 0;

        int compare = key.compareTo(h.key);
        if (compare < 0) return rank(h.left, key);
        else if (compare > 0) return size(h.left) + 1 + rank(h.right, key);
        else return size(h.left);
    }

    public Key select(int index) {
        return select(root, index);
    }

    Key select(Node h, int index) {
        if (h == null) return null;

        int n = size(h.left);
        if (n > index) return select(h.left, index);
        else if (n < index) return select(h.right, index - n - 1);
        else return h.key;
    }

    public Key floor(Key key) {
        Node floor = floor(root, key);
        if (floor == null) return null;
        return floor.key;
    }

    Node floor(Node h, Key key) {
        if (h == null) return null;

        int compare = key.compareTo(h.key);
        if (compare == 0) return h;
        else if (compare < 0) return floor(h.left, key);
        else {
            Node t = floor(h.right, key);
            if (t != null) return t;
            return h;
        }
    }

    public Key ceiling(Key key) {
        Node ceiling = ceiling(root, key);
        if (ceiling == null) return null;
        return ceiling.key;
    }

    Node ceiling(Node h, Key key) {
        if (h == null) return null;

        int compare = key.compareTo(h.key);
        if (compare == 0) return h;
        else if (compare > 0) return ceiling(h.right, key);
        else {
            Node t = ceiling(h.left, key);
            if (t != null) return t;
            return h;
        }
    }

    public String toString() {
        Queue<Key> queue = keys();
        return queue.toString() + " size = " + root.N;
    }
}
