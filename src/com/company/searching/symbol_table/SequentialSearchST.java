package com.company.searching.symbol_table;

public class SequentialSearchST<Key, Value> {
  private Node first;
  private class Node {
    Key key;
    Value value;
    Node next;
    public Node(Key key, Value value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  public Value get(Key key) {
    for (Node node = first; node != null; node = node.next) {
      if (key.equals(node.key)) return node.value;
    }

    return null;
  }

  public void put(Key key, Value value) {
    for (Node node = first; node != null; node = node.next) {
      if (key.equals(node.key)) {
        node.value = value;
        return;
      }
    }
    first = new Node(key, value, first);
  }

}
