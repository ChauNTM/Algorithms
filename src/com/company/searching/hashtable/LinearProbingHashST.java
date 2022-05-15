package com.company.searching.hashtable;

import java.lang.reflect.Array;

public class LinearProbingHashST<Key, Value> implements HashTable<Key, Value> {
    private int M;
    private int N;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int capacity) {
        this.M = capacity;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public LinearProbingHashST() {
        this(16);
    }

    @Override
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) return values[i];
        }
        return null;
    }

    private void resize(int size) {
        LinearProbingHashST<Key, Value> st = new LinearProbingHashST<>();

        for(int i=0; i<M; i++) {
            if (keys[i] != null) st.put(keys[i], values[i]);
        }
        this.M = size;
        this.keys = st.keys;
        this.values = st.values;
    }

    @Override
    public void put(Key key, Value value) {
        if (N >= M/2) resize(2*M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i+1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    private boolean contain(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contain(key)) return;

        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;

        while(keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }
}
