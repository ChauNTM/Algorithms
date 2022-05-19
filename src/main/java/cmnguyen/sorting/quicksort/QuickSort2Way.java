package main.java.cmnguyen.sorting.quicksort;

public class QuickSort2Way<T extends Comparable<T>> extends QuickSort<T> {

  @Override
  protected void sort(T[] a, int lo, int hi) {
    if (lo >= hi) return;
    int p = partitioning(a, lo, hi);
    sort(a, lo, p);
    sort(a, p+1, hi);
  }

  private int partitioning(T[] a, int lo, int hi) {
    T v = a[lo];
    int i = lo;
    int j = hi + 1;
    while (true) {
      while (a[++i].compareTo(v) <= 0) if (i == hi) break;
      while (v.compareTo(a[--j]) <= 0) if (j == lo) break;
      if (i >= j) break;
      exchange(a, i, j);
    }
    exchange(a, lo, j);
    return j;
  }
}
