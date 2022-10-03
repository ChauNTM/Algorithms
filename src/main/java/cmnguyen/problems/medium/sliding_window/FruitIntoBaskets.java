package main.java.cmnguyen.problems.medium.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static int totalFruit(int[] fruits) {
        int i = 0, j;
        Map<Integer, Integer> count = new HashMap<>();

        // because both i and j are increase, so when the window is invalid -> i, j increase by one
        // -> the previous valid window is unchanged
        for (j=0; j < fruits.length; j++) {
            count.put(fruits[j], count.getOrDefault(fruits[j], 0) + 1);
            if (count.size() > 2) {
                int c = count.get(fruits[i]);
                if (c > 1) count.put(fruits[i++], c - 1);
                else count.remove(fruits[i++]);
            }
            System.out.println("count=" + count + "i=" + i);
        }

        return j - i;
    }

}
