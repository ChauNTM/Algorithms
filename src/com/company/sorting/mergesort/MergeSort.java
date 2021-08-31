package com.company.sorting.mergesort;

import com.company.sorting.Sort;

import java.util.Comparator;

public abstract class MergeSort<T> extends Sort<T> {
  protected T[] aux;

  protected void merge(T[] a, int lo, int mid, int hi, Comparator<T> comparator) {
    int i = lo;
    int j = mid + 1;
    System.arraycopy(a, 0, aux, 0, a.length);

    for (int k = lo; k <= hi; k++) {
      if      (i > mid)         a[k] = aux[j++];
      else if (j > hi)          a[k] = aux[i++];
      else if (comparator.compare(aux[j], aux[i]) < 0) a[k] = aux[j++];
      else                      a[k] = aux[i++];
    }
  }
}
