package main.java.cmnguyen.sorting.quicksort;

public class QuickSort3Way<T extends Comparable<T>> extends QuickSort<T> {

  @Override
  protected void sort(T[] a, int lo, int hi) {
    if (hi <= lo) return;
    int lt = lo, gt = hi, i = lo + 1;
    T v = a[lo];
    while (i <= gt) {
      if (a[i].compareTo(v) < 0) exchange(a, lt++, i++);
      else if (a[i].compareTo(v) > 0) exchange(a, i, gt--);
      else i++;
    }
    sort(a, lo, lt - 1);
    sort(a, gt + 1, hi);
  }
}
