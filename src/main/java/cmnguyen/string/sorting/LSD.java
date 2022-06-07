package main.java.cmnguyen.string.sorting;

/**
 * Only use LSD for sorting String arrays with all elements which have the same length
* */
public class LSD {

    public static void sort(String[] a, int W) {
        int R = 256;
        int N = a.length;

        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // count frequency of d
            for (int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;

            // convert frequency into indices
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];

            // distribute a[i] into aux
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];

            // copy back to a
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }

    }
}
