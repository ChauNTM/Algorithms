package main.java.cmnguyen.problems.medium.merge_intervals;

import java.util.*;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> results = new ArrayList<>();
        int i = 0;

        while (i < intervals.length) {
            if (!results.isEmpty() && intervals[i][0] <= results.get(results.size()-1)[1]) {
                results.get(results.size()-1)[1] = Math.max(intervals[i++][1], results.get(results.size()-1)[1]);
            } else {
                results.add(intervals[i++]);
            }
        }

        return results.toArray(new int[results.size()][2]);
    }
}
