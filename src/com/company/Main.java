package com.company;

import com.company.searching.bst.BST;
import com.company.searching.symbol_table.BinarySearchST;
import com.company.sorting.heapsort.MaxPQ;

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
//
//        HeapSort<Integer> heapSort = new HeapSort<>();
//        heapSort.sort(array);
//        System.out.println("HeapSort result: " + Arrays.toString(array));

//        testPriorityQueue();
        testBST();

    }

    private static void testBST() {
        BST<Character, Integer> bst = new BST<>();
        bst.put('S', 1);
        bst.put('H', 19);
        bst.put('U', 10);
        bst.put('E', 100);
        bst.put('T', 0);
        bst.put('Z', 15);
        bst.put('A', 17);
        bst.put('F', 18);
        bst.put('W', 25);
        bst.put('M', 27);

        System.out.println("min: " + bst.min() + "\n");
        System.out.println("max: " + bst.max() + "\n");
        System.out.println("bst " + bst);

        System.out.println("lo and hi");
        Iterable<Character> keys1 = bst.keys('E', 'M');
        keys1.forEach(System.out::println);

        bst.deleteMin();
        System.out.println("bst " + bst);
        bst.delete('W');
        System.out.println("bst " + bst);

        System.out.println("bst floor of N: " + bst.floor('N'));
        System.out.println("bst ceil of N: " + bst.ceiling('N'));
        System.out.println("bst rank of M: " + bst.rank('M'));
        System.out.println("bst select of 3: " + bst.select(3));
    }

    private static void testBinarySearchST() {
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        st.put("S", 12);
        st.put("F", 11);
        st.put("S", 10);
        st.put("W", 101);
        st.put("X", 90);
        st.put("B", 120);
        st.put("M", 34);
        st.put("Z", 134);
        System.out.println("result = " + st);
        System.out.println("max = " + st.max());
        System.out.println("floor = " + st.floor("D"));
        System.out.println("ceil = " + st.ceiling("L"));
        st.delete("L");
        System.out.println("final result = " + st);
        st.delete("M");
        System.out.println("final result = " + st);
        System.out.println("find S: " + st.get("S"));
        System.out.println("find A: " + st.get("A"));
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


