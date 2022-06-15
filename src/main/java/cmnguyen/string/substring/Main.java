package main.java.cmnguyen.string.substring;

public class Main {

    public static void main(String[] args) {
        String text = "ABBBAACABABABADDFGABABACGF";
        String pattern = "ABABACG";

        System.out.println("Brute-force for searching substring: ");
        testBruteForce(text, pattern);

        System.out.println("\nKMP for searching substring: ");
        testKMP(text, pattern);

        System.out.println("\nBoyer-Moore for searching substring: ");
        testBoyerMoore(text, pattern);

        System.out.println("\nRabin-Karp for searching substring: ");
        testRabinKarp(text, pattern);
    }

    private static void testBruteForce(String text, String pattern) {
        System.out.printf("Position of pattern %s in %s is: %d", pattern, text, BruteForce.search(text, pattern));
    }

    private static void testKMP(String text, String pattern) {
        KMP kmp = new KMP(256, pattern);
        System.out.printf("Position of pattern %s in %s is: %d", pattern, text, kmp.search(text));
    }

    private static void testBoyerMoore(String text, String pattern) {
        BoyerMoore boyerMoore = new BoyerMoore(256, pattern);
        System.out.printf("Position of pattern %s in %s is: %d", pattern, text, boyerMoore.search(text));
    }

    private static void testRabinKarp(String text, String pattern) {
        RabinKarp rabinKarp = new RabinKarp(256, pattern);
        System.out.printf("Position of pattern %s in %s is: %d", pattern, text, rabinKarp.search(text));
    }
}
