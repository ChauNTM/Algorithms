package main.java.cmnguyen.string.substring;

public class KMP {
    private String pattern;
    private int[][] dfa;

    public KMP(int radix, String pattern) {
        this.pattern = pattern;
        int M = pattern.length();
        dfa = new int[radix][M];
        dfa[pattern.charAt(0)][0] = 1;
        int X = 0;
        for (int j = 0; j < M; j++) {
            dfa[pattern.charAt(j)][j] = j + 1;
            for (int c = 0; c < radix; c++) {
                dfa[c][j] = dfa[c][X];
            }
            X = dfa[pattern.charAt(j)][X];
        }
    }

    public int search(String text) {
        int N = text.length();
        int M = pattern.length();

        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[text.charAt(i)][j];
        }

        if (j == M) return i - M;
        return -1;
    }
}
