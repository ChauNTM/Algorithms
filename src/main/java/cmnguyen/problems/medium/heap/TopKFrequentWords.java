package main.java.cmnguyen.problems.medium.heap;

import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {
        Hashtable<String, Integer> hash = new Hashtable<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue());

        for (int i = 0; i < words.length; i++) {
            int count = hash.getOrDefault(words[i], 0);
            count++;
            hash.put(words[i], count);
        }

        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) pq.poll();
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) result.add(0, pq.poll().getKey());
        return result;
    }
}
