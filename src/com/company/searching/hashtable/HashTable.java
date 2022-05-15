package com.company.searching.hashtable;

public interface HashTable<Key, Value> {
    int hash(Key key);
    Value get(Key key);
    void put(Key key, Value value);
    void delete(Key key);
}
