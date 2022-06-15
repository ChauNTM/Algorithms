package main.java.cmnguyen.string.substring;

public class BoyerMoore {
    private int[] right;
    private String pattern;

    public BoyerMoore(int radix, String pattern) {
        this.pattern = pattern;
        right = new int[radix];
        int M = pattern.length();
        for (int c = 0; c < M; c++) right[c] = -1;
        for (int j = 0; j < M; j++) right[pattern.charAt(j)] = j;
    }

    public int search(String text) {
        int M = pattern.length();
        int N = text.length();

        int skip;
        for (int i = 0; i < N - M; i += skip) {
            skip = 0;
            for (int j = M-1; j >=0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {
                    skip = j - right[text.charAt(i + j)];
                    if (skip < 1) skip = 1;
                }
            }
            if (skip == 0) return i;
        }
        return -1;
    }
}
