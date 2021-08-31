package com.company.sorting.quicksort;

import com.company.sorting.Sort;

import java.util.Comparator;

public abstract class QuickSort<T> extends Sort<T> {
  public void sort(T[] a, Comparator<T> c) {
    sort(a, c,0, a.length-1);
  }

  protected abstract void sort(T[] a, Comparator<T> c, int lo, int hi);
}
