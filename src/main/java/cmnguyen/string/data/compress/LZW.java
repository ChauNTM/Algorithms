package main.java.cmnguyen.string.data.compress;

import main.java.cmnguyen.string.searching.TST;

import java.io.IOException;

public class LZW {
    private static int R = 256;     // number of input chars
    private static int L = 4096;    // number of codeword 2^12
    private static int W = 12;      // codeword width

    public static void compress(BinaryIn in, BinaryOut out) {
        try {
            String input = in.readString();

            TST<Integer> tst = new TST<>();
            for (int c = 0; c < R; c++) {
                tst.put("" + c, c);
            }
            int code = R + 1;

            while (input.length() > 0) {
                String s = tst.longestPrefixOf(input);
                out.write(tst.get(s), W);
                int length = s.length();
                if (length < input.length() && code < L) {
                    tst.put(input.substring(0, length + 1), code++);
                }
                input = input.substring(length);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.write(R);
            out.close();
        }
    }

    public static void expand(BinaryIn in, BinaryOut out) {
        String[] st = new String[R];
        int i;

        for (i = 0; i < R; i++)
            st[i] = "" + i;
        st[i++] = " ";      // lookahead for EOF

        try {
            int codeword = in.readInt(W);
            String val = st[codeword];
            while (true) {
                codeword = in.readInt(W);
                if (codeword == R) break;
                String s = st[codeword];
                if (i == codeword)
                    val = val + val.charAt(0);
                if (i < L)
                    st[i++] = val + s.charAt(0);
                val = s;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            out.close();
        }

    }
}
