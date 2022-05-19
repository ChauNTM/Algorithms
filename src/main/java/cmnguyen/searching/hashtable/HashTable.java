package main.java.cmnguyen.searching.hashtable;

import java.util.Queue;

public interface HashTable<Key, Value> {
    int hash(Key key);
    Value get(Key key);
    void put(Key key, Value value);
    void delete(Key key);
    boolean contains(Key key);
    Queue<Key> keys();
}
