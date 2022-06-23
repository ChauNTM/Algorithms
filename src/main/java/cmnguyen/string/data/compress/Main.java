package main.java.cmnguyen.string.data.compress;

public class Main {

    public static void main(String[] args) {
        testLZW();
    }

    private static void testGenomics() {
        String fileName = "src/main/resources/compressedTemp.txt";
        System.out.println("Compress genome file\nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/genomeTiny.txt");
        BinaryOut out = new BinaryOut(fileName);
        int N = Genomics.compress(in, out);
        System.out.println("Done");

        BinaryOut console = new BinaryOut();
        BinaryIn compressedInput = new BinaryIn(fileName);
        Genomics.expand(compressedInput, console, N);
    }

    private static void testCompressPicture() {
        String fileName = "src/main/resources/compressedTemp.bin";
        System.out.println("Compress picture file\nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/32x48.bin");
        BinaryOut out = new BinaryOut();
        RunLengthEncoding.compress(in, out);
        System.out.println("Done");

//        BinaryOut fileOutput = new BinaryOut("src/main/resources/32x48-01.bin");
//        BinaryIn compressedInput = new BinaryIn(fileName);
//        RunLengthEncoding.expand(compressedInput, fileOutput);
    }

    private static void testHuffman() {
        System.out.println("Compress Huffman \nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/huffman.txt");
        BinaryOut out = new BinaryOut("src/main/resources/huffman_temp.bin");
        Huffman.compress(in, out);
        System.out.println("Done");

        BinaryOut fileOutput = new BinaryOut("src/main/resources/huffman_result.txt");
        BinaryIn compressedInput = new BinaryIn("src/main/resources/huffman_temp.bin");
        Huffman.expand(compressedInput, fileOutput);
    }

    private static void testLZW() {
        System.out.println("Compress LZW \nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/lzw.txt");
        BinaryOut out = new BinaryOut("src/main/resources/lzw_temp.bin");
        Huffman.compress(in, out);
        System.out.println("Done");

        BinaryOut fileOutput = new BinaryOut("src/main/resources/lzw_result.txt");
        BinaryIn compressedInput = new BinaryIn("src/main/resources/lzw_temp.bin");
        Huffman.expand(compressedInput, fileOutput);
    }
}
