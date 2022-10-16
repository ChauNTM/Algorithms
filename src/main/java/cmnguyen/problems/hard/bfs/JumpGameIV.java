package main.java.cmnguyen.problems.hard.bfs;

import java.util.*;

public class JumpGameIV {
    public static int minJumps(int[] arr) {

        int n = arr.length;
        Map<Integer, List<Integer>> indexes = new HashMap<>();
        int step = 0;

        for (int i = 0; i < n; i++) {
            indexes.computeIfAbsent(arr[i], k -> new LinkedList<>()).add(i);
        }

        boolean[] marked = new boolean[n];
        Queue<Integer> minHeap = new ArrayDeque<>();
        minHeap.offer(0);
        marked[0] = true;

        while (!minHeap.isEmpty()) {
            int size = minHeap.size();

            while(--size >= 0) {
                int curId = minHeap.poll();
                if (curId == n-1) return step;

                List<Integer> nextIds = indexes.get(arr[curId]);
                nextIds.add(curId-1);
                nextIds.add(curId+1);
                for (int nextId: nextIds) {
                    if (nextId >= 0 && nextId < n && !marked[nextId]) {
                        marked[nextId] = true;
                        minHeap.offer(nextId);
                    }
                }
                nextIds.clear();
            }
            step++;
        }

        return step;
    }
}
