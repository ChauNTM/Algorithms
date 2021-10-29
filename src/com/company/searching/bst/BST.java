package com.company.searching.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key;
    private Value value;
    private Node left;
    private Node right;
    private int N;

    public Node(Key key, Value value, int N) {
      this.key = key;
      this.value = value;
      this.N = N;
    }
  }

  public int size() {
    return size(root);
  }

  private int size(Node node) {
    if (node == null) return 0;
    return node.N;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp < 0) return get(node.left, key);
    else if (cmp > 0) return get(node.right, key);
    else return node.value;
  }

  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value, 1);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left, key, value);
    else if (cmp > 0) node.right = put(node.right, key, value);
    else node.value = value;
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  public Key min() {
    return min(root).key;
  }

  private Node min(Node node) {
    if (node == null) return null;
    if (node.left == null) return node;
    return min(node.left);
  }

  public Key floor(Key key) {
    Node t = floor(root, key);
    if (t == null) return null;
    return t.key;
  }

  private Node floor(Node node, Key key) {
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp == 0) return node;
    if (cmp < 0) return floor(node.left, key);
    Node t = floor(node.right, key);
    if (t != null) return t;
    else return node;
  }

  public Key ceiling(Key key) {
    Node x = ceiling(root, key);
    if (x == null) return null;
    return x.key;
  }

  private Node ceiling(Node node, Key key) {
    if (node == null) return null;
    int cmp = key.compareTo(node.key);
    if (cmp == 0) return node;
    if (cmp > 0) return ceiling(node.right, key);
    Node t = ceiling(node.left, key);
    if (t != null) return t;
    else return node;
  }

  public Key select(int index) {
    Node x = select(root, index);
    if (x == null) return null;
    return x.key;
  }

  private Node select(Node node, int index) {
    if (node == null) return null;
    int t = size(node.left);
    if (t > index) return select(node.left, index);
    else if (t < index) return select(node.right, index - t - 1);
    else return node;
  }

  public int rank(Key key) {
    return rank(root, key);
  }

  private int rank(Node node, Key key) {
    if (node == null) return 0;

    int cmp = key.compareTo(node.key);
    if (cmp == 0) return size(node.left);
    else if (cmp < 0) return rank(node.left, key);
    return size(node.left) + 1 + rank(node.right, key);
  }

  public void deleteMin() {
    root = deleteMin(root);
  }

  private Node deleteMin(Node node) {
    if (node == null) return null;

    if (node.left == null) return node.right;
    node.left = deleteMin(node.left);
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  public void delete(Key key) {
    root = delete(root, key);
  }

  private Node delete(Node node, Key key) {
    if (node == null) return null;

    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = delete(node.left, key);
    else if (cmp > 0) node.right = delete(node.right, key);
    else {
      if (node.left == null) return node.right;
      if (node.right == null) return node.left;

      Node t = node;
      node = min(node.right);
      node.left = t.left;
      node.right = deleteMin(t.right);
    }
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  public Key max() {
    return max(root);
  }

  private Key max(Node node) {
    if (node == null) return null;
    if (node.right == null) return node.key;
    return max(node.right);
  }

  public Iterable<Key> keys() {
    return keys(min(), max());
  }

  public Iterable<Key> keys(Key lo, Key hi) {
    Queue<Key> queue = new LinkedList<>();
    keys(root, queue, lo, hi);
    return queue;
  }

  private void keys(Node node, Queue<Key> queue, Key lo, Key hi) {
    if (node == null) return;
    int cmpLo = lo.compareTo(node.key);
    int cmpHi = hi.compareTo(node.key);

    if (cmpLo < 0) keys(node.left, queue, lo, hi);
    if (cmpLo <= 0 && cmpHi >= 0) queue.add(node.key);
    if (cmpHi > 0) keys(node.right, queue, lo, hi);
  }

  public String toString() {
    Iterable<Key> keys = this.keys();
    return keys.toString();
  }

}
