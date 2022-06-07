package main.java.cmnguyen.string.sorting;

public class InsertionSort {

    public static void sort(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--) {
                exchange(a, j, j-1);
            }
        }
    }

    private static boolean less(String a, String b, int d) {
        return a.charAt(d) < b.charAt(d);
    }

    private static void exchange(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
