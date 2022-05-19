package main.java.cmnguyen.sorting;

import main.java.cmnguyen.sorting.heapsort.HeapSort;
import main.java.cmnguyen.sorting.heapsort.MaxPQ;
import main.java.cmnguyen.sorting.mergesort.HeapSort1;
import main.java.cmnguyen.sorting.quicksort.QuickSort;
import main.java.cmnguyen.sorting.quicksort.QuickSort3Way;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testSort();
    }

    private static void testSort() {
        Integer[] array = new Integer[] {2, 118, 10, 16, -2, 2, 100, 60, 70, 45, 17, 450, 18, 8};

        QuickSort<Integer> quickSort = new QuickSort3Way<>();
        quickSort.sort(array);
        System.out.println("Quick sort result: " + Arrays.toString(array));

        HeapSort1<Integer> mergeSort = new HeapSort1<>();
        mergeSort.sort(array);
        System.out.println("BottomUpMergeSort decrease result: " + Arrays.toString(array));

        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(array);
        System.out.println("HeapSort result: " + Arrays.toString(array));
    }

    private static void testPriorityQueue() {
        MaxPQ<Integer> queue = new MaxPQ<>(100);
        queue.insert(2);
        queue.insert(50);
        queue.insert(611);
        queue.insert(13);
        queue.insert(71);
        queue.insert(12);
        System.out.println("Priority queue");
        System.out.println(queue);
        queue.delMax();
        queue.insert(101);
        queue.delMax();
        queue.insert(-34);
        queue.insert(134);
        queue.delMax();
        System.out.println("Result: Priority queue");
        System.out.println(queue);
    }

}


