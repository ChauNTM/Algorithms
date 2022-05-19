package main.java.cmnguyen.sorting.quicksort;

import main.java.cmnguyen.sorting.Sort;

public abstract class QuickSort<T extends Comparable<T>> extends Sort<T> {
  public void sort(T[] a) {
    sort(a, 0, a.length-1);
  }

  protected abstract void sort(T[] a, int lo, int hi);
}
