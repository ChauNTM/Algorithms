package main.java.cmnguyen.problems.medium;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];
        path[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else if (i == 0) {
                    path[i][j] = path[i][j-1];
                } else if (j == 0) {
                    path[i][j] = path[i-1][j];
                } else {
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }
            }
        }

        return path[m-1][n-1];
    }

}
