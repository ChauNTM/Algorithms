package com.company.sorting.quicksort;

import com.company.sorting.Sort;

public abstract class QuickSort<T extends Comparable<T>> extends Sort<T> {
  public void sort(T[] a) {
    sort(a, 0, a.length-1);
  }

  protected abstract void sort(T[] a, int lo, int hi);
}
