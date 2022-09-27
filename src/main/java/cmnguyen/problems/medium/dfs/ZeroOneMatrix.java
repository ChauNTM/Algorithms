package main.java.cmnguyen.problems.medium.dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        for (int i=0; i < n; i++) {
            for (int j=0; j < m; j++) {
                if (mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }

        int[] d = new int[]{-1,0,1,0,-1};
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            for (int k=0; k < d.length -1; k++) {
                int r = i + d[k];
                int c = j + d[k+1];
                if (r < 0 || r >= n || c < 0 || c >= m || mat[r][c] < mat[i][j] + 1) continue;
                mat[r][c] = mat[i][j] + 1;
                queue.add(new int[]{r, c});
            }
        }

        return mat;
    }
}
