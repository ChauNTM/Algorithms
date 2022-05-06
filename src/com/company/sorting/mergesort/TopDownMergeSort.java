package com.company.sorting.mergesort;

import java.lang.reflect.Array;

public class TopDownMergeSort<T extends Comparable<T>> extends MergeSort<T> {

  @Override
  public void sort(T[] a) {
    aux = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
    sort(a, 0, a.length - 1);
  }

  public void sort(T[] a, int lo, int hi) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid + 1, hi);
    merge(a, lo, mid, hi);
  }
}
