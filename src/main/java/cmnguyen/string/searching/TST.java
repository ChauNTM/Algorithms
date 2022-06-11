package main.java.cmnguyen.string.searching;

import java.util.ArrayDeque;
import java.util.Queue;

public class TST<Value> {
    Node root;
    class Node {
        Node left, mid, right;
        char c;
        Value value;

        public Node(char c, Value value) {
            this.c = c;
            this.value = value;
        }

        public Node(char c) {
            this.c = c;
        }
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {
        char c = key.charAt(d);
        if (x == null) {
            x = new Node(c);
        }

        if (c < x.c) x.left = put(x.left, key, value, d);
        else if (c > x.c) x.right = put(x.right, key, value, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, value, d + 1);
        else x.value = value;

        return x;

    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return x.value;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;

        char c = key.charAt(d);
        if (c < x.c) return get(x.left, key, d);
        else if (c > x.c) return get(x.right, key, d);
        else if (d < key.length() - 1) return get(x.mid, key, d+1);
        else return x;
    }

    public String longestPrefixOf(String key) {
        int length = longestPrefixOf(root, key, 0, 0);
        return key.substring(0, length + 1);
    }

    private int longestPrefixOf(Node x, String key, int d, int length) {
        if (x == null) return length;

        if (x.value != null) length = d;
        if (d == key.length()) return length;

        int c = key.charAt(d);
        if (c < x.c) {
            return longestPrefixOf(x.left, key, d, length);
        } else if (c > x.c) {
            return longestPrefixOf(x.right, key, d, length);
        } else {
            return longestPrefixOf(x.mid, key, d + 1, length);
        }
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> queue = new ArrayDeque<>();
        collect(root, "", pat, queue);
        return queue;
    }

    private void collect(Node x, String pre, String pat, Queue<String> queue) {
        if (x == null) return;

        int d = pre.length();
        char c = pat.charAt(d);
        if (c == '.' || c < x.c) collect(x.left, pre, pat, queue);
        if (c == '.' || c == x.c) {
            if (d == pat.length() - 1 && x.value != null) queue.add(pre + x.c);
            if (d < pat.length() - 1) {
                collect(x.mid, pre + x.c, pat, queue);
            }
        }
        if (c == '.' || c > x.c) collect(x.right, pre, pat, queue);
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> queue = new ArrayDeque<>();
        Node x = get(root, pre, 0);
        if (x == null) return queue;
        if (x.value != null) queue.add(pre);
        collect(x.mid, pre, queue);
        return queue;
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) return;

        collect(x.left, pre, queue);
        if (x.value != null) queue.add(pre + x.c);
        collect(x.mid, pre + x.c, queue);
        collect(x.right, pre, queue);

    }
}
