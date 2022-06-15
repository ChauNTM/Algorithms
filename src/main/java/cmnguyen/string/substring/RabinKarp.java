package main.java.cmnguyen.string.substring;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
    // R^(M-1) % Q
    private long RM;
    // large random prime
    private long Q;
    private int M;
    private int R;
    private long patternHash;

    public RabinKarp(int radix, String pattern) {
        this.R = radix;
        this.M = pattern.length();
        this.Q = longRandomPrime();

        RM = 1;
        for (int i=1; i < M; i++) {
            RM = (R * RM) % Q;
        }
        patternHash = hash(pattern, M);

    }

    private long hash(String key, int M) {
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (h * R + key.charAt(i)) % Q;
        }
        return h;
    }

    private long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    private boolean check(int i) {
        return true;
    }

    public int search(String text) {
        int N = text.length();

        long txtHash = hash(text, M);
        if (txtHash == patternHash) return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * text.charAt(i - M) % Q) % Q;
            txtHash = (R*txtHash + text.charAt(i)) % Q;
            if (txtHash == patternHash)
                if (check(i - M + 1)) return i - M + 1;
        }
        return -1;
    }
}
