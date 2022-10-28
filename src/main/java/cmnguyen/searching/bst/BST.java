package main.java.cmnguyen.searching.bst;

public class BST<Key extends Comparable<Key>, Value> extends BSTAbstraction<Key, Value> {

  @Override
  public void put(Key key, Value value) {
    root = put(root, key, value);
  }

  private Node put(Node node, Key key, Value value) {
    if (node == null) return new Node(key, value);
    int cmp = key.compareTo(node.key);
    if (cmp < 0) node.left = put(node.left, key, value);
    else if (cmp > 0) node.right = put(node.right, key, value);
    else node.value = value;
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

  @Override
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
      node.right = deleteMin(t.right);
      node.left = t.left;
    }
    node.N = size(node.left) + size(node.right) + 1;
    return node;
  }

}
