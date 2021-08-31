package com.company.sorting.heapsort;

import com.company.sorting.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class HeapSort<T> extends Sort<T> {

  @Override
  public void sort(T[] array, Comparator<T> c) {
    int n = array.length;
    for (int i = n / 2; i >= 1; i--) {
      sink(array, i, n, c);
    }
    System.out.println("Heap result: " + Arrays.toString(array));

    while (n > 1) {
      exchange(array, 1, n--);
      sink(array, 1, n, c);
    }
  }

  private void swim(T[] a, int k, int n, Comparator<T> c) {
    while (k > 1 && less(a, k/2, k, c)) {
      exchange(a, k, k / 2);
      k = k / 2;
    }
  }

  private void sink(T[] a, int k, int n, Comparator<T> c) {
    while (2*k <= n) {
      int j = 2 * k;
      if (j < n && less(a, j, j+1, c)) j++;
      if (less(a, j, k, c)) break;
      exchange(a, k, j);
      k = j;
    }
  }

  private boolean less(T[] a, int k, int j, Comparator<T> c) {
    return c.compare(a[k-1], a[j-1]) < 0;
  }

  @Override
  protected void exchange(T[] a, int i, int j) {
    T temp = a[i-1];
    a[i-1] = a[j-1];
    a[j-1] = temp;
  }
}
