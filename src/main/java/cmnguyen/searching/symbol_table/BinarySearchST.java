package main.java.cmnguyen.searching.symbol_table;

import java.util.NoSuchElementException;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
  private static int INIT_CAPACITY = 2;
  private Key[] keys;
  private Value[] values;
  private int size;

  public BinarySearchST() {
    keys = (Key[]) new Comparable[INIT_CAPACITY];
    values = (Value[]) new Object[INIT_CAPACITY];
  }

  public int size() { return size;}

  private void resize(int capacity) {
    assert capacity > size;
    Key[] newKeys = (Key[]) new Comparable[capacity];
    Value[] newValues = (Value[]) new Object[capacity];

    for (int i=0; i<size; i++) {
      newKeys[i] = keys[i];
      newValues[i] = values[i];
    }

    keys = newKeys;
    values = newValues;
  }

  public Value get(Key key) {
    if (key == null) throw new IllegalArgumentException("Key in get() is null");
    if (isEmpty()) return null;
    int i = rank(key);
    // if key not found, then i = 0 and keys[0] != key, then return null
    if (i < size && keys[i].equals(key)) return values[i];
    else return null;
  }

  public void put(Key key, Value value) {
    if (key == null) throw new IllegalArgumentException("Key in put() is null");

    if (value == null) {
      delete(key);
      return;
    }

    int i = rank(key);
    if (i < size && keys[i].equals(key)) {
      values[i] = value;
      return;
    }
    if (size >= keys.length) resize(keys.length*2);

    for (int j = size; j>i; j--) {
      keys[j] = keys[j - 1];
      values[j] = values[j - 1];
    }
    keys[i] = key;
    values[i] = value;
    size++;
  }

  private boolean isEmpty() {
    return size == 0;
  }

  private int rank(Key key) {
    if (key == null) throw new IllegalArgumentException("Key in rank() is null");
    int lo = 0;
    int hi = size -1;
    while (lo <= hi) {
      int mid = lo + (hi - lo)/2;
      int compare = key.compareTo(keys[mid]);
      if (compare < 0) hi = mid - 1;
      else if (compare > 0) lo = mid+1;
      else return mid;
    }
    return lo;
  }

  public Key min() {
    return keys[0];
  }

  public Key max() {
    return keys[size -1];
  }

  public Key select(int k) {
    return keys[k];
  }

  public Key ceiling(Key key) {
    if (key == null) throw new IllegalArgumentException("Key in ceiling() is null");
    int i = rank(key);
    if (i == size) throw new NoSuchElementException("argument to ceiling() is too large");
    return keys[i];
  }

  public Key floor(Key key) {
    if (key == null) throw new IllegalArgumentException("Key in floor() is null");
    int i = rank(key);
    if (i < size && key.equals(keys[i])) return keys[i];
    if (i == 0) throw new NoSuchElementException("argument to floor() is too small");
    return keys[i - 1];
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("Key in delete() is null");
    if (isEmpty()) return;

    int i = rank(key);

    if (i == size || !key.equals(keys[i])) return;

    for (int j=i; j<size-1; j++) {
      keys[j] = keys[j+1];
      values[j] = values[j+1];
    }

    size--;
    keys[size] = null;
    values[size] = null;

    // resize if 1/4 full
    if (size > 0 && size <= keys.length/4) resize(keys.length/2);

  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.getClass().getSimpleName()).append("\n");
    for (int i=0; i<size; i++) {
      builder.append("(").append(keys[i]).append(", ").append(values[i]).append(")").append("    ");
    }
    return builder.toString();
  }
}
