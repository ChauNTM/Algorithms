package com.company;

import com.company.sorting.heapsort.HeapSort;
import com.company.sorting.heapsort.MaxPQ;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] array = new Integer[] {2, 118, 10, 16, -2, 2, 100, 60, 70, 45, 17, 450, 18, 8};
//        QuickSort<Integer> quickSort = new QuickSort3Way<>();
//        quickSort.sort(array);
//        System.out.println("Quick sort result: " + Arrays.toString(array));
//
//        MergeSort<Integer> mergeSort = new TopDownMergeSort<>();
//        mergeSort.sort(array);
//        System.out.println("BottomUpMergeSort decrease result: " + Arrays.toString(array));

        HeapSort<Integer> heapSort = new HeapSort<>();
        heapSort.sort(array);
        System.out.println("HeapSort result: " + Arrays.toString(array));
//
//        BST<Character, Integer> bst = new BST<>();
//        bst.put('S', 1);
//        bst.put('H', 19);
//        bst.put('U', 10);
//        bst.put('E', 100);
//        bst.put('T', 0);
//        bst.put('Z', 15);
//        bst.put('A', 17);
//        bst.put('F', 18);
//        bst.put('W', 25);
//        bst.put('M', 27);
//
//        System.out.println("min: " + bst.min() + "\n");
//        System.out.println("max: " + bst.max() + "\n");
//        System.out.println("bst " + bst.toString());
//
//        System.out.println("lo and hi");
//        Iterable<Character> keys1 = bst.keys('E', 'M');
//        keys1.forEach(System.out::println);
//
//        bst.deleteMin();
//        System.out.println("bst " + bst.toString());
//        bst.delete('W');
//        System.out.println("bst " + bst.toString());
//
//        System.out.println("bst floor of N: " + bst.floor('N'));

//        testPriorityQueue();

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
        queue.println();
        queue.delMax();
        queue.insert(101);
        queue.delMax();
        queue.insert(-34);
        queue.insert(134);
//        queue.delMax();
        System.out.println("Result: Priority queue");
        queue.println();
    }
}


