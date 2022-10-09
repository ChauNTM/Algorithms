package main.java.cmnguyen.problems.medium;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] path = new int[m][n];

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0 || j == 0) path[i][j] = 1;
                else {
                    path[i][j] = path[i][j-1] + path[i-1][j];
                }
            }
        }

        return path[m-1][n-1];

    }
}
