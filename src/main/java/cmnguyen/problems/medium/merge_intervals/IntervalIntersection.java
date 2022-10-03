package main.java.cmnguyen.problems.medium.merge_intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            if (firstList[i][1] < secondList[j][0]) i++;
            else if (firstList[i][0] > secondList[j][1]) j++;
            else {
                result.add(new int[]{Math.max(firstList[i][0], secondList[j][0]),
                        Math.min(firstList[i][1], secondList[j][1])});
                if (firstList[i][1] < secondList[j][1]) i++;
                else j++;
            }

        }

        return result.toArray(new int[result.size()][2]);
    }

}
