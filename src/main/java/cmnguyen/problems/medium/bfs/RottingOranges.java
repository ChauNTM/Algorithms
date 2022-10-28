package main.java.cmnguyen.problems.medium.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        int totalFreshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) totalFreshOrange++;
            }
        }

        int count = 0;
        int[] d = new int[]{-1, 0, 1, 0, -1};
        while (!q.isEmpty() && totalFreshOrange > 0) {
            int size = q.size();
            count++;

            while (size-- > 0) {
                int[] val = q.poll();
                for (int k=0; k < d.length - 1; k++) {
                    int r = val[0] + d[k];
                    int c = val[1] + d[k+1];
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (grid[r][c] == 0 || grid[r][c] == 2) continue;

                    grid[r][c] = 2;
                    totalFreshOrange--;

                    q.offer(new int[]{r, c});
                }
            }
        }

        return (totalFreshOrange > 0) ? -1 : count;
    }

}
