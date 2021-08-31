package com.company;

import com.company.sorting.*;
import com.company.sorting.heapsort.HeapSort;
import com.company.sorting.mergesort.MergeSort;
import com.company.sorting.mergesort.TopDownMergeSort;
import com.company.sorting.quicksort.QuickSort;
import com.company.sorting.quicksort.QuickSort3Way;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {2, 118, 10, 16, -2, 2, 100, 60, 70, 45, 17, 450, 18, 8};
        QuickSort<Integer> quickSort = new QuickSort3Way<>();
        quickSort.sort(array, Integer::compareTo);
        System.out.println("Quick sort result: " + Arrays.toString(array));

        MergeSort<Integer> mergeSort = new TopDownMergeSort<>();
        mergeSort.sort(array, (o1, o2) -> {
            if (o1.equals(o2)) return 0;
            else if (o1 > o2) return -1;
            else return 1;
        });
        System.out.println("BottomUpMergeSort decrease result: " + Arrays.toString(array));

        Sort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(array, Integer::compareTo);
        System.out.println("HeapSort result: " + Arrays.toString(array));
    }
}
