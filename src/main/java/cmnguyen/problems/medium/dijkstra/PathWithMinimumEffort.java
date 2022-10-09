package main.java.cmnguyen.problems.medium.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minHeap.add(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] d = new int[]{-1, 0, 1, 0, -1};
        while (!minHeap.isEmpty()) {
            int[] value = minHeap.poll();
            int distance = value[0];
            int i = value[1];
            int j = value[2];
            if (distance > dist[i][j]) continue;
            if (i == n - 1 && j == m - 1) return value[0];

            for (int k = 0; k < d.length - 1; k++) {
                int r = i + d[k];
                int c = j + d[k+1];
                if (r < 0 || r >= n || c < 0 || c >= m) continue;
                int newDistance = Math.max(distance, Math.abs(heights[r][c] - heights[i][j]));
                if (dist[r][c] > newDistance) {
                    dist[r][c] = newDistance;
                    minHeap.add(new int[]{newDistance, r, c});
                }
            }
        }

        return 0;
    }

}
