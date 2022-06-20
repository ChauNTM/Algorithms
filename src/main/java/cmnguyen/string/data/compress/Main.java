package main.java.cmnguyen.string.data.compress;

public class Main {

    public static void main(String[] args) {
        testGenomics();
    }

    private static void testGenomics() {
        System.out.println("Compress genome file\nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/genomeTiny.txt");
        BinaryOut out = new BinaryOut("src/main/resources/genomeCompressedTiny.txt");
        int N = Genomics.compress(in, out);
        System.out.println("Done");

        BinaryOut console = new BinaryOut();
        BinaryIn compressedInput = new BinaryIn("src/main/resources/genomeCompressedTiny.txt");
        Genomics.expand(compressedInput, console, N);
    }
}
