package main.java.cmnguyen.sorting;

public abstract class Sort<T extends Comparable<T>> {
  public abstract void sort(T[] a);

  protected void exchange(T[] a, int i, int j) {
    T temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
