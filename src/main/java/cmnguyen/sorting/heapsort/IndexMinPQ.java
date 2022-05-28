package main.java.cmnguyen.sorting.heapsort;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IndexMinPQ<Item extends  Comparable<Item>> {
    // binary heap using 1-based indexing, hold the indices
    private int[] pq;
    /**
     * inverse of pq - qp[pq[i]] = pq[qp[i]] = i in order to check whether index i was inserted into heap
     * if we don't keep reverse of pq, then contains() will take O(n) to loop through pq
     * */
    private int[] qp;
    // keys[i] = priority of i
    private Item[] items;
    private int n;
    private int maxN;

    public IndexMinPQ(int maxN) {
        this.maxN = maxN;
        n = 0;
        items = (Item[]) new Comparable[maxN + 1];
        pq = new int[maxN];
        qp = new int[maxN];
        for (int i=0; i<maxN; i++) {
            qp[i] = -1;
        }
    }

    private void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if (j < n && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exchange(j, k);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exchange(k, k/2);
            k = k/2;
        }
    }

    private void exchange(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private boolean greater(int i, int j) {
        return items[pq[i]].compareTo(items[pq[j]]) > 0;
    }

    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative");
        if (i > maxN) throw new IllegalArgumentException("index is out of range " + maxN);
    }

    public void insert(int i, Item item) {
        validateIndex(i);
        if (contains(i)) throw new IllegalArgumentException("Item is already in the priority queue");
        n++;
        pq[n] = i;
        qp[i] = n;
        items[i] = item;
        swim(n);
    }

    public void change(int i, Item item) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("Priority queue doesn't contain the item with index");
        items[i] = item;
        swim(qp[i]);
        sink(qp[i]);
    }

    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    public Item min() {
        int index = pq[1];
        return items[index];
    }

    public void delete(int i) {
        validateIndex(i);
        if (!contains(i)) throw new NoSuchElementException("Priority queue doesn't contain index");
        int k = qp[i];
        exchange(k, n--);
        sink(k);
        swim(k);
        items[i] = null;
        qp[i] = -1;
    }

    public int minIndex() {
        if (n == 0) throw new RuntimeException("priority queue is empty");
        return pq[1];
    }

    public Item minKey() {
        if (n == 0) throw new RuntimeException("priority queue is empty");
        return items[pq[1]];
    }

    /**
     * Only care about heapify on pq[], when change anything related to pq[], we must change qp[] as well
     * items[] always don't relate to pq[] because it is used to keep index of value
     * */
    public int delMin() {
        if (n == 0) throw new RuntimeException("priority queue is empty");
        int min = pq[1];
        exchange(1, n--);
        sink(1);
        assert min == pq[n+1];
        qp[min] = -1;        // delete
        items[min] = null;    // to help with garbage collection
        pq[n+1] = -1;        // not needed
        return min;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return n;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\npq[] " + Arrays.toString(pq))
                .append("\nqp[] " + Arrays.toString(qp))
                .append("\nitems[] " + Arrays.toString(items));
        return builder.toString();
    }
}
