package main.java.cmnguyen.string.data.compress;

public class Main {

    public static void main(String[] args) {
        testCompressPicture();
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
        String fileName = "src/main/resources/compressedTemp.txt";
        System.out.println("Compress picture file\nIn progress\n");
        BinaryIn in = new BinaryIn("src/main/resources/32x48.bin");
        BinaryOut out = new BinaryOut(fileName);
        RunLengthEncoding.compress(in, out);
        System.out.println("Done");

        BinaryOut fileOutput = new BinaryOut("src/main/resources/32x48-01.bin");
        BinaryIn compressedInput = new BinaryIn(fileName);
        RunLengthEncoding.expand(compressedInput, fileOutput);
    }
}
