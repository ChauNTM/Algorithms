package main.java.cmnguyen.problems.medium.dijkstra;

import java.util.*;

public class MinimumObstacleRemoval {

    public static int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distTo = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(distTo[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        minHeap.offer(new int[]{0, 0, 0});
        distTo[0][0] = 0;

        int[] move = new int[]{-1, 0, 1, 0, -1};
        while(!minHeap.isEmpty()) {
            int[] value = minHeap.poll();
            int d = value[0];
            int i = value[1];
            int j = value[2];
            if (i == n - 1 && j == m - 1) return distTo[i][j];
            if (distTo[i][j] < d) continue;

            for (int k=0; k < move.length-1; k++) {
                int r = i + move[k];
                int c = j + move[k+1];

                if (r < 0 || r >= n || c < 0 || c >= m) continue;
                int newDistance = distTo[i][j] + grid[r][c];
                if (distTo[r][c] > newDistance) {
                    distTo[r][c] = newDistance;
                    minHeap.offer(new int[]{newDistance, r, c});
                }
            }
        }

        return 0;
    }
}
