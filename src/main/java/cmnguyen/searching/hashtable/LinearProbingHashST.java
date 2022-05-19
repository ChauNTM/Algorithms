package main.java.cmnguyen.searching.hashtable;

import java.util.LinkedList;
import java.util.Queue;

public class LinearProbingHashST<Key, Value> implements HashTable<Key, Value> {
    int M;
    int N;
    Key[] keys;
    Value[] values;

    public LinearProbingHashST(int capacity) {
        M = capacity;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    @Override
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public Value get(Key key) {
        int index;
        for (index = hash(key); keys[index] != null; index = (index + 1) % M) {
            if (keys[index].equals(key)) {
                return values[index];
            }
        }
        return null;
    }

    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> st = new LinearProbingHashST<>(capacity);
        for (int i=0; i<M; i++) {
            if (keys[i] != null)
                st.put(keys[i], values[i]);
        }
        M = st.M;
        N = st.N;
        keys = st.keys;
        values = st.values;
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("key can not be null");
        if (value == null) {
            delete(key);
            return;
        }

        if (N >= M/2) resize(2*M);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }

        keys[i] = key;
        values[i] = value;
        N++;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key can not be null");
        if (!contains(key)) return;

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                values[i] = null;
                break;
            }
        }

        for (i = (i +1) % M; keys[i] != null; i = (i + 1) % M) {
            Key keyToRehash = keys[i];
            Value valueToRehash = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRehash, valueToRehash);
        }
        N--;

        if (N > 0 && N <= M/8) resize(M/2);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public Queue<Key> keys() {
        Queue<Key> queue = new LinkedList<>();
        for (int i=0; i<M; i++) {
            if (keys[i] != null)
                queue.add(keys[i]);
        }
        return queue;
    }

    public String toString() {
        return keys().toString();
    }
}
