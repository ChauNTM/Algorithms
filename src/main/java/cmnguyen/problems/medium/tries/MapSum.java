package main.java.cmnguyen.problems.medium.tries;

import java.util.ArrayDeque;
import java.util.Queue;

public class MapSum {
    private static final int R = 256;
    Node root;

    private static class Node {
        private Node[] next = new Node[R];
        private int value = Integer.MAX_VALUE;
    }

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        root = insert(root, key, val, 0);
    }

    private Node insert(Node x, String key, int val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            x.value = val;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = insert(x.next[c], key, val, d+1);
        return x;
    }

    public int get(String key) {
        Node x = get(root, key, 0);
        if (x != null) return x.value;
        return 0;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length()) return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    private int collect(Node x, String prefix) {
        if (x == null) return 0;
        int sum = 0;
        if (x.value != Integer.MAX_VALUE) sum += x.value;

        for (char c = 0; c < R; c++) {
           if (x.next[c] != null) sum += collect(x.next[c], prefix + c);
       }

       return sum;
    }

    public int sum(String prefix) {
        return collect(get(root, prefix, 0), prefix);
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> queue = new ArrayDeque<>();
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) return;

        if (x.value != Integer.MAX_VALUE) queue.add(pre);
        for(char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, queue);
        }
    }
}
