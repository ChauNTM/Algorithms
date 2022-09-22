package main.java.cmnguyen.problems.medium.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ColoringBorder {

    // BFS
//    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        int[] d = new int[]{0, 1, 0, -1, 0};
//        int n = grid.length;
//        int m = grid[0].length;
//        Queue<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{row, col});
//        int[][] marked = new int[n][m];
//        marked[row][col] = -1;
//        int oldColor = grid[row][col];
//
//        while (!queue.isEmpty()) {
//            int i = queue.peek()[0];
//            int j = queue.poll()[1];
//
//            if (i >= 0 && i < n && j >= 0 && j < m) {
//                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
//                    grid[i][j] = color;
//                }
//
//                for (int k = 0; k < d.length - 1; k++) {
//                    int r = i + d[k];
//                    int c = j + d[k+1];
//
//                    if (r >= 0 && r < n && c >= 0 && c < m && marked[r][c] != -1) {
//                        if (grid[r][c] != oldColor) grid[i][j] = color;
//                        else {
//                            marked[r][c] = -1;
//                            queue.offer(new int[]{r, c});
//                        }
//                    }
//                }
//            }
//        }
//
//        return grid;
//    }

    //DFS
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int[][] marked = new int[grid.length][grid[0].length];
        dfs(grid, marked, row, col, grid[row][col], color);
        return grid;
    }

    private static int dfs(int[][] grid, int[][] marked, int i, int j, int originalColor, int color) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (marked[i][j] == -1) return 1;
            if (grid[i][j] != originalColor) return 0;
            marked[i][j] = -1;
            if (dfs(grid, marked,i-1, j, originalColor, color) +
                    dfs(grid, marked,i + 1, j, originalColor, color) +
                    dfs(grid, marked, i, j-1, originalColor, color) +
                    dfs(grid, marked, i, j+1, originalColor, color) < 4)
                grid[i][j] = color;
            return 1;
        } else {
            return 0;
        }
    }

}
