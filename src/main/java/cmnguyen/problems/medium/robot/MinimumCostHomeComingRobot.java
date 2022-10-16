package main.java.cmnguyen.problems.medium.robot;

public class MinimumCostHomeComingRobot {

//    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
//        if (Arrays.compare(startPos, homePos) == 0) return 0;
//        int dy = homePos[0] - startPos[0];
//        int dx = homePos[1] - startPos[1];
//        System.out.println("dy=" + dy + " dx=" + dx);
//
//        int cost = 0;
//        for (int k = 1; k <= Math.abs(dy); k++) {
//            cost += rowCosts[startPos[0] + (dy > 0 ? k : - k)];
//        }
//
//        System.out.println("cost=" + cost);
//        for (int k = 1; k <= Math.abs(dx); k++) {
//            System.out.println("colCosts[startPos[1] + k]=" + colCosts[startPos[1] + k]);
//            cost += colCosts[startPos[1] + (dx > 0 ? k : -k)];
//        }
//
//        return cost;
//    }

    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int cost = 0, i = startPos[0], j = startPos[1], x = homePos[0], y = homePos[1];

        while(i != x) {
            i += (x - i) / Math.abs(x-i);
            cost += rowCosts[i];
        }

        while (j != y) {
            j += (y - j) / Math.abs(y-j);
            cost += colCosts[j];
        }

        return cost;
    }
}
