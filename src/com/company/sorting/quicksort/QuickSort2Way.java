package com.company.sorting.quicksort;

import java.util.Comparator;

public class QuickSort2Way<T> extends QuickSort<T> {

  @Override
  protected void sort(T[] a, Comparator<T> c, int lo, int hi) {
    if (lo >= hi) return;
    int p = partitioning(a, c, lo, hi);
    sort(a, c, lo, p);
    sort(a, c, p+1, hi);
  }

  private int partitioning(T[] a, Comparator<T> c, int lo, int hi) {
    T v = a[lo];
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (c.compare(a[++i], v) <= 0) if (i == hi) break;
      while (c.compare(v, a[--j]) <= 0) if (j == lo) break;
      if (i >= j) break;
      exchange(a, i, j);
    }
    exchange(a, lo, j);
    return j;
  }
}
