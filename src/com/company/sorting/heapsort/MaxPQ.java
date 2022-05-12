package com.company.sorting.heapsort;

public class MaxPQ<Key extends Comparable<Key>> {
  private Key[] pq;
  private int size = 0;

  public MaxPQ(int maxN) {
    pq = (Key[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void insert(Key v) {
    pq[++size] = v;
    swim(size);
  }

  public Key delMax() {
    Key max = pq[1];
    exchange(1, size);
    pq[size] = null;
    size--;
    sink(1);
    return max;
  }

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exchange(int i, int j) {
    Key temp = pq[i];
    pq[i] = pq[j];
    pq[j] = temp;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exchange(k, k / 2);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k < size) {
      int j = 2 * k;
      if (j < size && less(j, j + 1)) ++j;
      if (!less(k, j)) break;
      exchange(k, j);
      k = j;
    }
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("N=").append(size).append("\n");
    for(int i = 1; i <= size; i++) {
      builder.append(pq[i]).append("    ");
    }
    return builder.toString();
  }
}
