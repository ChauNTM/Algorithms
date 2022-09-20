package main.java.cmnguyen.problems.medium;

import java.util.*;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix, int startI, int startJ) {
        List<Integer> result = new ArrayList<>();
        int n = matrix[0].length;
        int m = matrix.length;
        int i = 0;
        int j = 0;

        for (int ki = 0, kj = 0; ki < m && kj < n; ki++, kj++) {
            if (i == 0) result.add(i, kj);
            else if (kj == n - 1) result.add(ki, n-1);
            else if (i == m - 1) j = n - kj;
        }

        return result;
    }
}
