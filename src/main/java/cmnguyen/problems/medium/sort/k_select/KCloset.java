package main.java.cmnguyen.problems.medium.sort.k_select;

import java.util.Arrays;

public class KCloset {

//    public static int[][] kClosest(int[][] points, int k) {
//        Arrays.sort(points, (o1, o2) -> {
//            int dist1 = o1[0] * o1[0] + o1[1] * o1[1];
//            int dist2 = o2[0] * o2[0] + o2[1] * o2[1];
//            return Integer.compare(dist1, dist2);
//        });
//        int[][] result = new int[k][2];
//        for (int i = 0; i < k; i++) result[i] = points[i];
//        return result;
//    }

    // k select like quicksort solution
    public static int[][] kClosest(int[][] points, int k) {
        if (points.length <= k) return points;
        int lo = 0;
        int hi = points.length - 1;
        while(lo < hi) {
            int mid = partitioning(points, lo, hi);
            if (k == mid) break;
            if (mid < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return Arrays.copyOf(points, k);
    }

    private static int partitioning(int[][] points, int lo, int hi) {
        int i = lo + 1;
        int j = hi;
        int[] v = points[lo];
        while(true) {
            while(less(points[i], v) && i < hi) i++;
            while(less(v, points[j]) && j > lo) j--;
            if (i >= j) break;
            exchange(points, i, j);
        }
        exchange(points, lo, j);
        return j;
    }

    private static boolean less(int[] pointA, int[] pointB) {
        return (pointA[0]*pointA[0] + pointA[1]*pointA[1])
                <= (pointB[0]*pointB[0] + pointB[1]*pointB[1]);
    }

    private static void exchange(int[][] points, int i, int j) {
        if (i == j) return;
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

}
