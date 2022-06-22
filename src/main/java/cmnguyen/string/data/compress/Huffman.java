package main.java.cmnguyen.string.data.compress;

import main.java.cmnguyen.sorting.heapsort.MinPQ;

import java.io.IOException;
import java.util.Arrays;

public class Huffman {
    private static int R = 256;

    static class Node implements Comparable<Node> {
        private char ch;
        private Node left, right;
        private int freq;

        public Node(char ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public static void expand(BinaryIn input, BinaryOut output) {
        try {
            Node root = readTrie(input);
            int N = input.readInt();
            for (int i=0; i < N; i++) {
                Node x = root;
                while (!x.isLeaf()) {
                    boolean bit = input.readBoolean();
                    if (bit) x = x.right;
                    else x = x.left;
                }
                output.write(x.ch, 8);
            }
        } catch (IOException ex) {
            System.out.println("Exception while expand " + ex);
        } finally {
            output.close();
        }
    }

    public static void compress(BinaryIn input, BinaryOut output) {
        try {
            String inputString = input.readString();
            char[] characters = inputString.toCharArray();

            int[] freq = new int[R];
            for (char character : characters) {
                freq[character]++;
            }

            Node root = buildTrie(freq);

            // Build code table
            String[] st = buildCode(root);

            // Write trie
            writeTrie(root, output);

            // Write input's length
            output.write(characters.length);

            for (int i = 0; i < characters.length; i++) {
                String code = st[characters[i]];
                for (int j = 0; j < code.length(); j++)
                    if (code.charAt(j) == '1')
                        output.writeBit(true);
                    else
                        output.writeBit(false);
            }
        } catch (IOException ex) {
            System.out.println("Exception while compress " + ex);
        } finally {
            output.close();
        }
    }

    private static void writeTrie(Node x, BinaryOut output) {
        if (x.isLeaf()) {
            output.writeBit(true);
            output.write(x.ch, 8);
            return;
        }
        output.writeBit(false);
        writeTrie(x.left, output);
        writeTrie(x.right, output);
    }

    private static Node readTrie(BinaryIn input) throws IOException {
        boolean bit = input.readBoolean();
        if (bit) {
            return new Node(input.readChar(), 0, null, null);
        }
        return new Node('\0', 0, readTrie(input), readTrie(input));
    }

    private static Node buildTrie(int[] freq) {
        MinPQ<Node> pq = new MinPQ<>(100);
        for (char c = 0; c < R; c++)
            if (freq[c] > 0) pq.insert(new Node(c, freq[c], null, null));

        while (pq.size() > 1) {
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    private static String[] buildCode(Node root) {
        String[] st = new String[R];
        buildCode(root, st, "");
        return st;
    }

    private static void buildCode(Node x, String[] st, String code) {
        if (!x.isLeaf()) {
            buildCode(x.left, st, code + '0');
            buildCode(x.right, st, code + '1');
        } else {
            st[x.ch] = code;
        }

    }
}
