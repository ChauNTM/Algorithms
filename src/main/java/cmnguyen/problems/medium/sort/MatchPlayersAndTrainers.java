package main.java.cmnguyen.problems.medium.sort;

import java.util.Arrays;

public class MatchPlayersAndTrainers {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int count = 0;
        for (int i=0, j = 0; i < players.length && j < trainers.length; j++) {
            if (players[i] <= trainers[j]) {
                count++;
                i++;
            }
        }

        return count;
    }
}
