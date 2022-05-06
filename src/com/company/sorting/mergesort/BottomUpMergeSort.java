package com.company.sorting.mergesort;

import java.lang.reflect.Array;

public class BottomUpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

  public void sort(T[] a) {
    aux = (T[]) Array.newInstance(a.getClass().getComponentType(), a.length);
    int n = a.length;
    for (int sz = 1; sz < n; sz = sz + sz) {
      for (int lo = 0; lo < n - sz; lo = lo + sz + sz) {
        merge(a, lo, lo + sz - 1, Math.min((lo + sz + sz - 1), n - 1));
      }
    }
  }
}
