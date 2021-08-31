package com.company.sorting.quicksort;

import java.util.Comparator;

public class QuickSort3Way<T> extends QuickSort<T> {

  @Override
  protected void sort(T[] a, Comparator<T> c, int lo, int hi) {
    if (hi <= lo) return;
    int lt = lo, gt = hi, i = lo + 1;
    T v = a[lo];
    while (i <= gt) {
      if (c.compare(a[i], v) < 0) exchange(a, lt++, i++);
      else if (c.compare(a[i], v) > 0) exchange(a, i, gt--);
      else i++;
    }
    sort(a, c, lo, lt - 1);
    sort(a, c, gt + 1, hi);
  }
}
