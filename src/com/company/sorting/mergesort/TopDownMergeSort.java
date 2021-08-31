package com.company.sorting.mergesort;

import java.lang.reflect.Array;
import java.util.Comparator;

public class TopDownMergeSort<T> extends MergeSort<T> {

  @Override
  public void sort(T[] a, Comparator<T> c) {
    aux = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
    sort(a, 0, a.length - 1, c);
  }

  public void sort(T[] a, int lo, int hi, Comparator<T> c) {
    if (hi <= lo) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid, c);
    sort(a, mid + 1, hi, c);
    merge(a, lo, mid, hi, c);
  }
}
