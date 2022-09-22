package main.java.cmnguyen.problems.easy;

public class IslandPerimeter {

//    public static int islandPerimeter(int[][] grid) {
//        for (int i=0; i < grid.length; i++) {
//            for (int j=0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    return dfs(grid, i, j);
//                }
//            }
//        }
//
//        return 0;
//    }
//
//    private static int dfs(int[][] grid, int i, int j) {
//        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
//            if (grid[i][j] == 0) return 1;
//            if (grid[i][j] == -1) return 0;
//            grid[i][j] = -1;
//            return dfs(grid, i - 1, j) + dfs(grid, i + 1, j)
//                    + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
//        } else {
//            return 1;
//        }
//    }

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        int neighbor = 0;

        for (int i=0; i < grid.length; i++) {
            for (int j=0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbor++;
                    if (j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbor++;
                }

            }
        }

        return 4*count - 2*neighbor;
    }

}
