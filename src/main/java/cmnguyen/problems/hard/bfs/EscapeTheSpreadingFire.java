package main.java.cmnguyen.problems.hard.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class EscapeTheSpreadingFire {

    public static int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] != 0) return -1;
        boolean[][] stepMarked = new boolean[m][n];

        int step = 0;
        int spreadingFire = 0;

        Queue<int[]> q = new ArrayDeque<>();

        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (grid[i][j] == 1) q.offer(new int[]{i, j, 0});
            }
        }

        stepMarked[0][0] = true;
        // last value is for person or fire, person is 1 and fire is 0
        q.offer(new int[]{0, 0, 1});
        int[] d = new int[]{-1, 0, 1, 0, -1};
        boolean isSpreading = false;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean isRunning = false;

            while(size-- > 0) {
                int[] val = q.poll();
                // check for spreading fire
                if (val[2] == 0 && !isSpreading) {
                    if (val[0] == m - 1 && val[1] == n - 1) {
                        isSpreading = true;
                    } else {
                        for (int k = 0; k < d.length - 1; k++) {
                            int r = val[0] + d[k];
                            int c = val[1] + d[k+1];

                            if (r < 0 || r >= m || c < 0 || c >= n ||
                                    grid[r][c] == 2 || grid[r][c] == 1 || grid[r][c] == -1) continue;

                            grid[r][c] = -1;
                            q.offer(new int[]{r, c, 0});
                        }
                    }
                }
                else if (val[2] == 1) {
                    if (val[0] == m - 1 && val[1] == n - 1) continue;
                    for (int k = 1; k < d.length - 2; k++) {
                        int r = val[0] + d[k];
                        int c = val[1] + d[k+1];

                        if (r < 0 || r >= m || c < 0 || c >= n ||
                                stepMarked[r][c] || grid[r][c] == 2 || grid[r][c] == -1 || grid[r][c] == 1) continue;

                        isRunning = true;
                        stepMarked[r][c] = true;
                        q.offer(new int[]{r, c, 1});
                    }
                }
            }
            if (isRunning) step++;
            if (!isSpreading) ++spreadingFire;
        }
        if (!stepMarked[m-1][n-1]) return -1;
        if (stepMarked[m-1][n-1] && grid[m-1][n-1] != -1) return 10^6;
        return (spreadingFire < step) ? -1 : (spreadingFire - step - 1);
    }

}
