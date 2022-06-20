package main.java.cmnguyen.string.data.compress;

import java.io.IOException;

public class Genomics {

    public static int compress(BinaryIn in, BinaryOut out) {
        Alphabet DNA = Alphabet.DNA;
        int lgR = DNA.lgR();
        int N = 0;
        try {
            while (!in.isEmpty()) {
                char c = in.readChar();
                N++;
                out.write(DNA.toIndex(c), lgR);
            }
        } catch (IOException ex) {
            System.out.println("Exception while compress DNA " + ex);
        } finally {
            out.close();
        }
        return N;
    }

    public static void expand(BinaryIn in, BinaryOut out, int N) {
        Alphabet DNA = Alphabet.DNA;
        int lgR = DNA.lgR();
        int count = 0;
        try {
            while (!in.isEmpty()) {
                if (N == count) return;
                int index = in.readChar(lgR);
                count++;
                out.write(DNA.toChar(index));
            }
        } catch (IOException ex) {
            System.out.println("Exception while compress DNA " + ex);
        } finally {
            out.close();
        }
    }


}
