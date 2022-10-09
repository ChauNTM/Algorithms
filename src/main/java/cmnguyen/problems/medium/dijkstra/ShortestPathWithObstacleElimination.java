package main.java.cmnguyen.problems.medium.dijkstra;

import java.util.*;

public class ShortestPathWithObstacleElimination {

    public static int shortestPath(int[][] grid, int max) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][][] marked = new boolean[n][m][max+1];
        int step = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0});
        marked[0][0][0] = true;

        int[] d = new int[]{-1, 0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (--size >= 0) {
                int[] top = queue.poll();
                int i = top[0];
                int j = top[1];
                int obstacles = top[2];
                if (i == n - 1 && j == m - 1) return step;

                for (int k = 0; k < d.length-1; k++) {
                    int r = i + d[k];
                    int c = j + d[k+1];

                    if (r < 0 || r >= n || c < 0 || c >= m) continue;
                    int newObstacles = obstacles + grid[r][c];
                    if (newObstacles <= max && !marked[r][c][newObstacles]) {
                        marked[r][c][newObstacles] = true;
                        queue.offer(new int[]{r, c, newObstacles});
                    }
                }
            }
            step++;
        }

        return -1;
    }

}
