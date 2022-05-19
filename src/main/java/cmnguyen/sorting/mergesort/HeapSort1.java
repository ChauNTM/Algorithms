package main.java.cmnguyen.sorting.mergesort;

public class HeapSort1<T extends Comparable<T>> {

    public void sort(T[] a) {
        int n = a.length;
        // build heap
        for (int k=n/2; k>=1; k--) {
            sink(a, n, k);
        }

        while(n >= 1) {
            exchange(a, 1, n);
            n--;
            sink(a, n, 1);
        }

    }

    void swim(T[] a, int k) {
        while(k > 1 && !less(a, k, k/2)) {
            exchange(a, k, k/2);
            k = k/2;
        }
    }

    void sink(T[] a, int n, int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(a, j, j+1)) j++;
            if (less(a, j, k)) break;
            exchange(a, k, j);
            k = j;
        }
    }

    boolean less(T[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) <= 0;
    }

    void exchange(T[] a, int i, int j) {
        T temp = a[i-1];
        a[i-1] = a[j-1];
        a[j-1] = temp;
    }



}
