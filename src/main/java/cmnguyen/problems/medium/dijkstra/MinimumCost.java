package main.java.cmnguyen.problems.medium.dijkstra;

import java.util.*;

public class MinimumCost {

    public static int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] distTo = new int[n][m];
        for (int i=0; i < n; i++) Arrays.fill(distTo[i], Integer.MAX_VALUE);

        Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0, 0});
        distTo[0][0] = 0;

        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[0];
            int j = top[1];

            for (int k = 0; k < d.length; k++) {
                int r = i + d[k][0];
                int c = j + d[k][1];
                if (r < 0 || r >= n || c < 0 || c >= m || (r == i && c == j)) continue;
                int newCost = (r == i + d[grid[i][j] - 1][0] && c == j + d[grid[i][j] - 1][1])? distTo[i][j] : distTo[i][j] + 1;
                if (distTo[r][c] > newCost) {
                    distTo[r][c] = newCost;
                    pq.offer(new int[]{r, c});
                }
            }
        }

        return distTo[n-1][m-1];
    }

}
