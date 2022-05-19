package main.java.cmnguyen.sorting.mergesort;

import main.java.cmnguyen.sorting.Sort;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
  protected T[] aux;

  protected void merge(T[] a, int lo, int mid, int hi) {
    int i = lo;
    int j = mid + 1;
    System.arraycopy(a, 0, aux, 0, a.length);

    for (int k = lo; k <= hi; k++) {
      if      (i > mid)         a[k] = aux[j++];
      else if (j > hi)          a[k] = aux[i++];
      else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
      else                      a[k] = aux[i++];
    }
  }
}
