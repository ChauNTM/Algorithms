package main.java.cmnguyen.string.sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] arrays = new String[]{"4PGC938", "2IYE230", "3CIO720", "1ICK750",
                "1OHV845", "4JZY524", "1ICK750", "3CIO720", "1OHV845", "1OHV845",
                "2RLA629", "2RLA629", "3ATW723", "13ATW73", "13ATW73", "14AAB123",
                "17AWB19", "18RMA19", "12ALA69", "23ABW03", "24ATW73", "13ATW93"};
        testLSD(arrays);
        System.out.println();
        test3WayQuickSort(arrays);
    }

    private static void testLSD(String[] arrays) {
        LSD.sort(arrays, arrays[0].length());
        System.out.println("LSD After sort: " + Arrays.toString(arrays));
    }

    private static void testMSD(String[] arrays) {
        MSD.sort(arrays);
        System.out.println("MSD After sort: " + Arrays.toString(arrays));
    }

    private static void test3WayQuickSort(String[] arrays) {
        ThreeWayQuickSort.sort(arrays);
        System.out.println("3-ways quicksort After sort: " + Arrays.toString(arrays));
    }
}
