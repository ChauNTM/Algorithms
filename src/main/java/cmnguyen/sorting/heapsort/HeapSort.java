package main.java.cmnguyen.sorting.heapsort;

import main.java.cmnguyen.sorting.Sort;

import java.util.Arrays;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] array) {
    int n = array.length;
    for (int i = n / 2; i >= 1; i--) {
      sink(array, i, n);
    }
    System.out.println("Heap result: " + Arrays.toString(array));

    while (n > 1) {
      exchange(array, 1, n--);
      sink(array, 1, n);
    }
  }

  private void swim(T[] a, int k) {
    while (k > 1 && less(a, k/2, k)) {
      exchange(a, k, k / 2);
      k = k / 2;
    }
  }

  private void sink(T[] a, int k, int n) {
    while (2*k <= n) {
      int j = 2 * k;
      if (j < n && less(a, j, j+1)) j++;
      if (less(a, j, k)) break;
      exchange(a, k, j);
      k = j;
    }
  }

  private boolean less(T[] a, int k, int j) {
    return a[k-1].compareTo(a[j-1]) < 0;
  }

  @Override
  protected void exchange(T[] a, int i, int j) {
    T temp = a[i-1];
    a[i-1] = a[j-1];
    a[j-1] = temp;
  }
}
