package main.java.cmnguyen.string.data.compress;

import java.util.Arrays;

public class Alphabet {

    /**
     *  The DNA alphabet { A, C, T, G }.
     */
    public static final Alphabet DNA = new Alphabet("ACGT");

    /**
     *  The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    // the characters in the alphabet
    private char[] alphabets;

    // indices
    private int[] inverse;

    // radix
    private int R;

    public Alphabet(String alphabet) {

        // check whether alphabet contains duplicated characters
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("characters in alphabet are duplicated");
            unicode[c] = true;
        }

        R = alphabet.length();
        alphabets = alphabet.toCharArray();

        inverse = new int[Character.MAX_VALUE];
        Arrays.fill(inverse, -1);

        for (int c = 0; c < R; c++) inverse[alphabets[c]] = c;
    }

    public Alphabet(int radix) {
        R = radix;
        alphabets = new char[R];
        inverse = new int[R];
        for (int i=0; i < R; i++) {
            alphabets[i] = (char) i;
            inverse[i] = i;
        }
    }

    public int toIndex(char c) {
        if (inverse[c] == -1) throw new IllegalArgumentException("character " + c + " is not in alphabets");
        return inverse[c];
    }

    public char toChar(int index) {
        if (index < 0 || index >= R) throw new IllegalArgumentException("index " + index + " is out of range");
        return alphabets[index];
    }

    public int lgR() {
        int lg = 0;
        for (int t = R - 1; t >= 1; t /= 2) {
            lg++;
        }
        return lg;
    }
}
