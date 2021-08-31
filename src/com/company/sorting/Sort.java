package com.company.sorting;

import java.util.Comparator;

public abstract class Sort<T> {
  public abstract void sort(T[] a, Comparator<T> c);

  protected void exchange(T[] a, int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
