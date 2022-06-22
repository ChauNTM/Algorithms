package main.java.cmnguyen.string.data.compress;

import java.io.IOException;

public class RunLengthEncoding {
    private static int MAX_COUNT = 255;

    public static void compress(BinaryIn in, BinaryOut out) {
        boolean old = false;
        char count = 0;
        try {
            while (!in.isEmpty()) {
                boolean bit = in.readBoolean();
                System.out.println("log debug=" + bit);
                if (bit != old) {
                    out.write(count);
                    old = !old;
                    count = 0;
                }
                else if (count == MAX_COUNT) {
                    out.write(count);
                    count = 0;
                    out.write(count);
                }
                count++;
            }
        } catch (IOException ex) {
            System.out.println("Exception while compress " + ex);
        } finally {
            out.close();
        }
    }

    public static void expand(BinaryIn in, BinaryOut out) {
        boolean bit = false;
        try {
            while (!in.isEmpty()) {
                char count = in.readChar();
                for (char i = 0; i < count; i++) {
                    out.writeBit(bit);
                }
                bit = !bit;
            }
        } catch (IOException ex) {
            System.out.println("Exception while expand " + ex);
        } finally {
            out.close();
        }
    }
}
