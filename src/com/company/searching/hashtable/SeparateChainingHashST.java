package com.company.searching.hashtable;

import com.company.searching.symbol_table.SequentialSearchST;

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
        st[hash(key)].put(key, value);
    }

    @Override
    public void delete(Key key) {

    }
}
