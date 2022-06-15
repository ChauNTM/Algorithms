package main.java.cmnguyen.string.substring;

public class BruteForce {

    public static int search(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i -= j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        else return -1;
    }
}
