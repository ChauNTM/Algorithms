package main.java.cmnguyen.problems.medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumConsecutiveCards {

    public static int minimumCardPickup(int[] cards) {
        int n = cards.length;
        int res = n+1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int preId = map.getOrDefault(cards[i], -1);
            if (preId > -1) {
                res = Math.min(res, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }
        if (res == n+1) return -1;
        return res;
    }
}
