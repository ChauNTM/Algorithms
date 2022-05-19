package main.java.cmnguyen.searching.symbol_table;

import java.util.LinkedList;
import java.util.Queue;

public class SequentialSearchST<Key, Value> {
  private Node first;
  int n;
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
    n++;
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to delete() is null");
    first = delete(first, key);
  }

  public boolean contains(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    return get(key) != null;
  }

  private Node delete(Node x, Key key) {
    if (x == null) return null;

    if (x.key.equals(key)) {
      n--;
      return x.next;
    }
    x.next = delete(x.next, key);
    return x;
  }

  public Queue<Key> keys() {
    Queue<Key> queue = new LinkedList<>();
    for (Node node = first; node != null; node = node.next) {
      queue.add(node.key);
    }
    return queue;
  }

}
