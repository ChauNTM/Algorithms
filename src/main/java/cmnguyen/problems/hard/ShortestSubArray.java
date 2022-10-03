package main.java.cmnguyen.problems.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestSubArray {

    public static int shortestSubarray(int[] A, int k) {
        int n = A.length;
        long[] B = new long[n+1];
        int res = n + 1;

        for(int i = 0; i < n; i++) B[i+1] = B[i] + A[i];

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (q.size() > 0 && B[i] - B[q.getFirst()] >= k)
                res = Math.min(res, i - q.pollFirst());

            while(q.size() > 0 && B[i] <= B[q.getLast()])
                q.pollLast();

            q.addLast(i);
        }
        if (res == n + 1) return -1;

        return res;
    }
}
