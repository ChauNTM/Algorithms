package com.company.searching.hashtable;

import com.company.searching.symbol_table.SequentialSearchST;

import java.util.IllformedLocaleException;
import java.util.LinkedList;
import java.util.Queue;

public class SeparateChainingHashST<Key, Value> implements HashTable<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i<M; i++)
            st[i] = new SequentialSearchST<>();
    }

    @Override
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllformedLocaleException("Key can not be null");
        if (value == null) {
            delete(key);
            return;
        }

        if (N >= M/2) resize(2*M);

        int index = hash(key);
        if (!st[index].contains(key)) N++;
        st[index].put(key, value);
    }

    @Override
    public void delete(Key key) {
        int index = hash(key);
        if (st[index].contains(key)) N--;
        st[index].delete(key);

        if (N > 0 && N <= M/8) resize(M/2);
    }

    @Override
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("key can not be null");
        return get(key) != null;
    }

    @Override
    public Queue<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i=0; i<M; i++) {
            queue.addAll(st[i].keys());
        }
        return queue;
    }

    private void resize(int capacity) {
        SeparateChainingHashST<Key, Value> resizedST = new SeparateChainingHashST<>(capacity);
        for (int i=0; i<M; i++) {
            for (Key key: st[i].keys()) {
                resizedST.put(key, st[i].get(key));
            }
        }
        this.M = resizedST.M;
        this.N = resizedST.N;
        this.st = resizedST.st;
    }

    public String toString() {
        return keys().toString();
    }
}
