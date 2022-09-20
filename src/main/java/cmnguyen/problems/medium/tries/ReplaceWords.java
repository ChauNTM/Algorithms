package main.java.cmnguyen.problems.medium.tries;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class ReplaceWords {
    private static int R = 26;

    public static String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String key : dictionary) {
            trie.put(key);
        }

        StringBuilder builder = new StringBuilder();
        for (String str : sentence.split(" ")) {
            builder.append(trie.shortestPrefixOf(str)).append(" ");
        }

        return builder.substring(0, builder.length()-1);
    }

    private static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        public void put(String key) {
            root = put(root, key, 0);
        }

        private Node put(Node x, String key, int d) {
            if (x == null) x = new Node();
            if (d == key.length()) {
                x.val = true;
                return x;
            }
            int c = key.charAt(d) - 'a';
            x.next[c] = put(x.next[c], key, d+1);
            return x;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) return null;
            if (key.length() == d) return x;
            int c = key.charAt(d) - 'a';
            return get(x.next[c], key, d+1);
        }

        public String shortestPrefixOf(String key) {
            int length = search(root, key, 0);
            if (length != -1) return key.substring(0, length);
            return key;
        }

        public int search(Node x, String key, int d) {
            if (x == null) return -1;
            if (x.val) return d;
            if (d == key.length()) return key.length();
            int c = key.charAt(d) - 'a';
            return search(x.next[c], key, d+1);
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

            if (x.val) queue.add(pre);
            for(char c = 0; c < R; c++) {
                collect(x.next[c], pre + c, queue);
            }
        }
    }

    private static class Node {
        boolean val = false;
        Node[] next = new Node[R];
    }
}
