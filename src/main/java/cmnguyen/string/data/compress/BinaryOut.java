package main.java.cmnguyen.string.data.compress;

import java.io.*;

public class BinaryOut {

    private BufferedOutputStream out;   // the output stream

    private int buffer;                 // 8-bit buffer of bits to write out

    private int n;                      // number of bits remaining in buffer

    public BinaryOut() {
        out = new BufferedOutputStream(System.out);
    }

    public BinaryOut(String fileName) {
        File file = new File(fileName);
        try {
            OutputStream os = new FileOutputStream(file);
            out = new BufferedOutputStream(os);
        } catch (FileNotFoundException e) {
            System.out.println("Exception when init file output stream " + e);
        }
    }

    private void clearBuffer() {
        if (n == 0) return;
        if (n > 0) buffer <<= (8 - n);

        try {
            out.write(buffer);
        } catch (IOException ex) {
            System.out.println("Exception when while writing buffer to output stream " + ex);
        }
        n = 0;
        buffer = 0;
    }

    public void writeBit(boolean x) {
        // add bit to buffer
        buffer <<= 1;
        if (x) buffer |= 1;
        // increase n and clear buffer if needed
        n++;
        if (n == 8) clearBuffer();
    }

    public void writeByte(int x) {
        if (n == 0) {
            try {
                out.write(x);
            } catch (IOException ex) {
                System.out.println("Exception when while writing buffer to output stream" + ex);
            }
            return;
        }

        for (int i = 0; i < 8; i++) writeBit(((x >>> (8 - i - 1)) & 1) == 1);
    }

    /**
     * Writes the 8-bit char to the binary output stream.
     *
     * @param  x the {@code char} to write
     * @throws IllegalArgumentException unless {@code x} is betwen 0 and 255
     */
    public void write(char x) {
        if (x >= 256) throw new IllegalArgumentException("Illegal 8-bit char = " + x);
        writeByte(x);
    }

    /**
     * Flushes the binary output stream, padding 0s if number of bits written so far
     * is not a multiple of 8.
     */
    public void flush() {
        clearBuffer();
        try {
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Flushes and closes the binary output stream.
     * Once it is closed, bits can no longer be written.
     */
    public void close() {
        flush();
        try {
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * Write last r bits to the binary output stream
     *  @throws IllegalArgumentException unless {@code r} is between 1 and 32
     *  @throws IllegalArgumentException unless {@code x} is between 0 and 2^r - 1
     */
    public void write(int x, int r) {
        if (r == 32) {
            write(x);
            return;
        }

        if (r < 1 || r > 32) throw new IllegalArgumentException("r is out of range");
        if (x >= (1 << r)) throw new IllegalArgumentException("Illegal " + r + "-bit char = " + x);
        for (int i = 0; i < r; i++) {
            boolean bit = ((x >>> (r - i - 1)) & 1) == 1;
            writeBit(bit);
        }
    }

    /**
     * Writes the 32-bit int to the binary output stream.
     * @param x the {@code int} to write
     */
    public void write(int x) {
        writeByte((x >>> 24) & 0xff);
        writeByte((x >>> 16) & 0xff);
        writeByte((x >>>  8) & 0xff);
        writeByte((x >>>  0) & 0xff);
    }

}
