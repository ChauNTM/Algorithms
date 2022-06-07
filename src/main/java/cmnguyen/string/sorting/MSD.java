package main.java.cmnguyen.string.sorting;

public class MSD {
    private static String[] aux;
    private static int R = 256;
    private static int M = 15;

    public static void sort(String[] a) {
        aux = new String[a.length];
        sort(a, 0, a.length-1, 0);
    }

    private static int charAt(String a, int d) {
        if (d >= a.length()) return -1;
        else return a.charAt(d);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo + M) {
            InsertionSort.sort(a, lo, hi, d);
            return;
        }
        // count[0] is unused, and count[R] is used for the last character in R alphabet
        int[] count = new int[R + 2];

        // count frequency of dth character at every items in a
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;

        // convert frequency into indices
        for (int r = 0; r <= R; r++)
            count[r+1] += count[r];

        // distribute items in a to aux
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        // copy back to a
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d + 1);

    }
}
