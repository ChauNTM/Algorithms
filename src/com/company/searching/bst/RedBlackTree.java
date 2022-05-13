package com.company.searching.bst;

import java.util.NoSuchElementException;

public class RedBlackTree<Key extends Comparable<Key>, Value> extends BSTAbstraction<Key, Value> {
    boolean isRed(Node h) {
        if (h == null) return false;
        else return h.color == RED;
    }

    boolean isEmpty() {
        return root == null;
    }

    Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    void flipColors(Node h) {
        h.color = !h.color;
        if (h.left != null) h.left.color = !h.left.color;
        if (h.right != null) h.right.color = !h.right.color;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    Node put(Node h, Key key, Value value) {
        if (h == null) return new Node(key, value, RED);

        int compare = key.compareTo(h.key);
        if (compare < 0) h.left = put(h.left, key, value);
        else if (compare > 0) h.right = put(h.right, key, value);
        else h.value = value;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = size(h.left) + size(h.right) + 1;
        return h;

    }

    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST underflow");

        if (!isRed(root.left) && !isRed(root.right))
            root.color = RED;

        root = deleteMin(root);
        if (!isEmpty()) root.color = BLACK;
    }

//    Node moveRedLeft(Node h) {
//        flipColors(h);
//
//        if (h.right != null && isRed(h.right.left)) {
//            h.right = rotateRight(h.right);
//            h = rotateLeft(h);
//            flipColors(h);
//        }
//
//        return h;
//    }

//    Node balance(Node h) {
//        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
//        if (isRed(h.left) && isRed(h.right)) flipColors(h);
//        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
//
//        h.N = size(h.left) + size(h.right) + 1;
//
//        return h;
//    }

    private Node balance(Node h) {
        // assert (h != null);

        if (isRed(h.right) && !isRed(h.left))    h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))     flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

//    Node deleteMin(Node h) {
//        if (h.left == null) return null;
//
//        if (!isRed(h.left) && !isRed(h.left.left))
//            h = moveRedLeft(h);
//
//        h.left = deleteMin(h.left);
//        return balance(h);
//    }

    private Node deleteMin(Node h) {
        if (h.left == null)
            return null;

        if (!isRed(h.left) && !isRed(h.left.left))
            h = moveRedLeft(h);

        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node moveRedLeft(Node h) {
        // assert (h != null);
        // assert isRed(h) && !isRed(h.left) && !isRed(h.left.left);

        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }
}

