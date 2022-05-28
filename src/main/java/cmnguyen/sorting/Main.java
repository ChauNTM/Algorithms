package main.java.cmnguyen.sorting;

import main.java.cmnguyen.sorting.heapsort.HeapSort;
import main.java.cmnguyen.sorting.heapsort.IndexMinPQ;
import main.java.cmnguyen.sorting.heapsort.MinPQ;
import main.java.cmnguyen.sorting.mergesort.HeapSort1;
import main.java.cmnguyen.sorting.quicksort.QuickSort;
import main.java.cmnguyen.sorting.quicksort.QuickSort3Way;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testPriorityQueue();
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
        MinPQ<Integer> queue = new MinPQ<>(100);
        queue.insert(2);
        queue.insert(50);
        queue.insert(611);
        queue.insert(13);
        queue.insert(71);
        queue.insert(12);
        System.out.println("Priority queue");
        System.out.println(queue);
        queue.delMin();
        queue.insert(101);
        queue.delMin();
        queue.insert(-34);
        queue.insert(134);
        queue.delMin();
        System.out.println("Result: Priority queue");
        System.out.println(queue);
    }

    private static void testIndexPQ() {
        IndexMinPQ<Integer> pq = new IndexMinPQ<>(20);
        pq.insert(3, 5);
        pq.insert(10, 50);
        pq.insert(1, 2);
        System.out.println("IndexMinPQ " + pq);

        pq.delMin();
        System.out.println("IndexMinPQ " + pq);
    }

}


