package main.java.cmnguyen.string.data.compress;

import java.io.*;

public class BinaryIn {

    private static final int EOF = -1;  // end of file
    int n;                              // number of bits left in buffer
    BufferedInputStream inputStream;    // the input stream
    int buffer;                         // one character buffer

    public BinaryIn() {
        inputStream = new BufferedInputStream(System.in);
        fillBuffer();
    }

    public BinaryIn(String fileName) {
        File file = new File(fileName);
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                inputStream = new BufferedInputStream(fis);
                fillBuffer();
            }
        } catch (IOException ex) {
            System.out.println("Exception while open file");
        }
    }

    private void fillBuffer() {
        try {
            buffer = inputStream.read();
            n = 8;
        } catch (IOException ex) {
            buffer = EOF;
            n = -1;
        }
    }

    public boolean exits() {
        return inputStream != null;
    }

    public boolean isEmpty() {
        return buffer == EOF;
    }

    /**
     * Reads the next bit of data from this binary input stream and return as a boolean.
     *
     * @return the next bit of data from this binary input stream as a {@code boolean}
     * @throws IOException if this binary input stream is empty
     */
    public boolean readBoolean() throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");
        n --;
        // only take the last bit after shift right n bit, so we use & 1
        boolean bit = ((buffer >> n) & 1) == 1;
        if (n == 0) fillBuffer();
        return bit;
    }

    public char readChar() throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        if (n == 8) {
            int x = buffer;
            fillBuffer();
            return (char) (x & 0xff);
        }

        // combine n last bit of current buffer with 8-n bit of next buffer
        int x = buffer;
        x = buffer << (8-n);
        int oldN = n;
        fillBuffer();
        if (isEmpty()) throw new IOException("Reading from empty input stream");
        n = oldN;
        x |= buffer >>> n;
        return (char) (x & 0xff);
    }

    public int readInt() throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        int x = 0;
        for (int i = 0; i < 4; i++) {
            char c = readChar();
            x <<= 8;
            x |= c;
        }
        return x;
    }

    public short readShort() throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        short x = 0;
        for (int i = 0; i < 2; i++) {
            char c = readChar();
            x <<= 8;
            x|= c;
        }
        return x;
    }

    public String readString() throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        StringBuilder builder = new StringBuilder();
        while (!isEmpty()) {
            char c = readChar();
            builder.append(c);
        }
        return builder.toString();
    }

    public int readInt(int r) throws IOException {
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        if (r == 32) return readInt();

        int x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

    public char readChar(int r) throws IOException{
        if (isEmpty()) throw new IOException("Reading from empty input stream");

        if (r == 8) return readChar();

        char x = 0;
        for (int i = 0; i < r; i++) {
            x <<= 1;
            boolean bit = readBoolean();
            if (bit) x |= 1;
        }
        return x;
    }

}
