package com.company.searching.red_black;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
  private static boolean RED = true;
  private static boolean BLACK = false;

  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left, right;
    int N;
    private boolean color;

    Node(Key key, Value value, int N, boolean color) {
      this.key = key;
      this.value = value;
      this.N = N;
      this.color = color;
    }

    public boolean isRed() {
      return color == RED;
    }
  }

  private boolean isRed(Node x) {
    if (x == null) return false;
    return x.isRed();
  }

  private int size(Node x) {
    if (x == null) return 0;
    return x.N;
  }

  private Node rotateLeft(Node h) {
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  private Node rotateRight(Node h) {
    Node x = h.left;
    h.left = x.right;
    x.right = h;
    x.color = h.color;
    h.color = RED;
    x.N = h.N;
    h.N = 1 + size(h.left) + size(h.right);
    return x;
  }

  private Node flipColors(Node h) {
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
    return h;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
    root.color = BLACK;
  }

  private Node put(Node h, Key key, Value value) {
    if (h == null)
      return new Node(key, value, 0, RED);
    // Do standard insert like BST
    int cmp = key.compareTo(h.key);
    if (cmp < 0) put(h.left, key, value);
    else if (cmp > 0) put(h.right, key, value);
    else h.value = value;

    // Do extra steps check in red-black tree to correct the tree
    if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
    if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
    if (isRed(h.left) && isRed(h.right)) flipColors(h);

    h.N = 1 + size(h.left) + size(h.right);
    return h;
  }

  

}
