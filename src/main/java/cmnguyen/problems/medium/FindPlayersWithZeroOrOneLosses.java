package main.java.cmnguyen.problems.medium;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losers = new TreeMap<>();

        for (int[] match : matches) {
            losers.put(match[1], losers.getOrDefault(match[1], 0) + 1);
            losers.put(match[0], losers.getOrDefault(match[0], 0));
        }

        List<List<Integer>> result = List.of(new ArrayList<>(), new ArrayList<>());

        for (int key : losers.keySet()) {
            int id = losers.get(key);
            if (id <= 1) result.get(losers.get(key)).add(key);
        }
        return result;
    }

}
