package main.java.cmnguyen.string.searching;

import java.util.ArrayDeque;
import java.util.Queue;

public class TriesST<Value> {
    static private final int R = 256;
    Node root;

    static class Node {
        Object val;
        Node[] next;

        public Node() {
            next = new Node[R];
        }

        public Node(Object val) {
            this.val = val;
            next = new Node[R];
        }
    }

    public TriesST() {
        root = new Node();
    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {

        if (x == null) x = new Node();
        if (d == key.length()) {
            x.val = value;
            return x;
        }
        int c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d+1);

        return x;
    }

    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x != null) return (Value) x.val;
        return null;
    }

    private Node get(Node x, String key, int d) {
        if (x == null) return null;
        // Because root doesn't contain any value and character
        if (d == key.length()) return x;
        int c = key.charAt(d);
        return get(x.next[c], key, d+1);
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

        if (x.val != null) queue.add(pre);
        for(char c = 0; c < R; c++) {
            collect(x.next[c], pre + c, queue);
        }
    }

    /*
    * x is a node that points to all keys which are started by pre
    * */
    private void collect(Node x, String pre, String pat, Queue<String> queue) {
        if (x == null) return;
        int d = pre.length();

        if (pat.length() == d && x.val != null) queue.add(pre);
        // We do not need to consider keys that are longer than pat
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for(char c=0; c < R; c++)
            if (next == '.' || c == next) collect(x.next[c], pre + c, pat, queue);

    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> queue = new ArrayDeque<>();
        collect(root, "", pat, queue);
        return queue;
    }

    /**
     * Return longest prefix of s which is found in tries
     * */
    public String longestPrefixOf(String s) {
        int length = longestPrefixOf(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int longestPrefixOf(Node x, String s, int d, int length) {
        if (x == null) return length;

        if (x.val != null) length = d;
        if (d == s.length()) return length;
        int c = s.charAt(d);
        return longestPrefixOf(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) x.val = null;
        else {
            int c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.val != null) return x;

        for (int c = 0; c < R; c++) {
            if (x.next[c] != null) return x;
        }
        return null;
    }

}
