package main.java.cmnguyen.searching;

import main.java.cmnguyen.searching.bst.BST;
import main.java.cmnguyen.searching.bst.RedBlackTree;
import main.java.cmnguyen.searching.hashtable.HashTable;
import main.java.cmnguyen.searching.hashtable.LinearProbingHashST;
import main.java.cmnguyen.searching.symbol_table.BinarySearchST;

public class Main {

    public static void main(String[] args) {
        testRedBlackTree();
    }

    private static void testRedBlackTree() {
        RedBlackTree<Character, Integer> rbTree = new RedBlackTree<>();
        rbTree.put('S', 1);
        rbTree.put('H', 19);
        rbTree.put('U', 10);
        rbTree.put('E', 100);
        rbTree.put('T', 0);
        rbTree.put('Z', 15);
        rbTree.put('A', 17);
        rbTree.put('F', 18);
        rbTree.put('W', 25);
        rbTree.put('M', 27);

        System.out.println("min: " + rbTree.min() + "\n");
        System.out.println("max: " + rbTree.max() + "\n");
        System.out.println("Red-Black tree " + rbTree);

        rbTree.deleteMin();
        System.out.println("Delete min Red-Black tree " + rbTree);
        rbTree.deleteMin();
        System.out.println("Delete min Red-Black tree " + rbTree);

        rbTree.deleteMax();
        System.out.println("Delete max Red-Black tree " + rbTree);

        System.out.println("Red-Black tree floor of N: " + rbTree.floor('N'));
        System.out.println("Red-Black tree floor of W: " + rbTree.floor('W'));
        System.out.println("Red-Black tree ceil of N: " + rbTree.ceiling('N'));
        System.out.println("Red-Black tree rank of M: " + rbTree.rank('M'));
        System.out.println("Red-Black tree select of 3: " + rbTree.select(3));
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

        System.out.println("keys between E and M");
        Iterable<Character> keys1 = bst.keys('E', 'M');
        System.out.println(keys1.toString());

        bst.deleteMin();
        System.out.println("Delete min bst " + bst);
        bst.delete('W');
        System.out.println("Delete W bst " + bst);

        System.out.println("bst floor of N: " + bst.floor('N'));
        System.out.println("bst floor of W: " + bst.floor('W'));
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

    private static void testHashTable() {
        HashTable<Character, Integer> st = new LinearProbingHashST<>(23);
        st.put('A', 18);
        st.put('B', 180);
        st.put('Z', 23);
        st.put('W', 10);
        st.put('L', 3);
        st.put('T', 5);
        st.put('K', 120);
        st.put('U', 110);
        st.put('H', 23);
        st.put('O', 20);

        System.out.println("Hashtable: " + st);
        System.out.println("Hashtable search result: " + st.get('K'));
        st.delete('K');
        System.out.println("Hashtable after delete K: " + st);
        st.delete('A');
        System.out.println("Hashtable after delete A: " + st);

    }
}
