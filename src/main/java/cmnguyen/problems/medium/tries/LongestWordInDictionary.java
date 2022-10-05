package main.java.cmnguyen.problems.medium.tries;

import java.util.ArrayDeque;
import java.util.Queue;

public class LongestWordInDictionary {

    public static String longestWord(String[] words) {
        Trie trie = new Trie();
        for (int i =0; i < words.length; i++) {
            trie.put(words[i], words[i].length());
        }
        System.out.println("keys: ");
        for(String word : trie.keys()) {
            System.out.println(word);
        }

        Queue<String> res = trie.keys();
        if (res.isEmpty()) return "";
        return res.poll();

    }


    private static class Trie {
        private static final int R = 26;
        private Node root;

        private static class Node {
            Node[] next = new Node[R];
            int value = -1;
        }

        public int get(String key) {
            Node x = get(root, key, 0);
            if (x == null) return -1;
            return x.value;
        }

        private Node get(Node x, String key, int d) {
            if (x == null) return null;
            if (key.length() == d) return x;

            return get(x.next[key.charAt(d) - 'a'], key, d+1);
        }

        public void put(String key, int value) {
            root = put(root, key, value, 0);
        }

        private Node put(Node x, String key, int value, int d) {
            if (x == null) x = new Node();
            if (key.length() == d) {
                x.value = value;
                return x;
            }
            int c = key.charAt(d) - 'a';
            x.next[c] = put(x.next[c], key, value, d+1);
            return x;
        }

        public Queue<String> keys() {
            return keysWithPrefix("");
        }

        private Queue<String> keysWithPrefix(String pre) {
            Queue<String> q = new ArrayDeque<>();
            collect(get(root, pre, 0), pre, q);
            return q;
        }

        private void collect(Node x, String pre, Queue<String> q) {
            if (x == null) return;
            if (x.value != -1) {
                if (q.isEmpty()) q.add(pre);
                else if (q.peek().length() < pre.length()){
                    q.poll();
                    q.add(pre);
                }
            }
            for (char c = 0; c < R; c++)
                if (x.next[c] != null && x.next[c].value != -1)
                    collect(x.next[c], pre + (char)(c + 'a'), q);
        }

    }

}
