package main.java.cmnguyen.problems.hard.diikstra;

import java.util.*;

public class MinimumCost {

//    public static int minCost(int[][] grid) {
//        int n = grid.length;
//        int m = grid[0].length;
//
//        int[][] distTo = new int[n][m];
//        for (int i=0; i < n; i++) Arrays.fill(distTo[i], Integer.MAX_VALUE);
//
//        Queue<int[]> pq = new LinkedList<>();
//        pq.add(new int[]{0, 0});
//        distTo[0][0] = 0;
//
//        int[][] d = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//        while(!pq.isEmpty()) {
//            int[] top = pq.poll();
//            int i = top[0];
//            int j = top[1];
//
//            for (int k = 0; k < d.length; k++) {
//                int r = i + d[k][0];
//                int c = j + d[k][1];
//                if (r < 0 || r >= n || c < 0 || c >= m || (r == i && c == j)) continue;
//                int newCost = (r == i + d[grid[i][j] - 1][0] && c == j + d[grid[i][j] - 1][1])? distTo[i][j] : distTo[i][j] + 1;
//                if (distTo[r][c] > newCost) {
//                    distTo[r][c] = newCost;
//                    pq.offer(new int[]{r, c});
//                }
//            }
//        }
//
//        return distTo[n-1][m-1];
//    }

    static int INF = (int) 1e9;
    static int[][] DIR = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length, cost = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], INF);
        Queue<int[]> bfs = new LinkedList<>();
        dfs(grid, 0, 0, dp, cost, bfs);
        while (!bfs.isEmpty()) {
            cost++;
            for (int size = bfs.size(); size > 0; size--) {
                int[] top = bfs.poll();
                int r = top[0], c = top[1];
                for (int i = 0; i < 4; i++) dfs(grid, r + DIR[i][0], c + DIR[i][1], dp, cost, bfs);
            }
        }
        return dp[m - 1][n - 1];
    }

    static void dfs(int[][] grid, int r, int c, int[][] dp, int cost, Queue<int[]> bfs) {
        int m = grid.length; int n = grid[0].length;
        if (r < 0 || r >= m || c < 0 || c >= n || dp[r][c] != INF) return;
        dp[r][c] = cost;
        bfs.offer(new int[]{r, c}); // add to try change direction later
        int nextDir = grid[r][c] - 1;
        dfs(grid, r + DIR[nextDir][0], c + DIR[nextDir][1], dp, cost, bfs);
    }

}
