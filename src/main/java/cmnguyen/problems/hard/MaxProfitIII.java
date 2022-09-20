package main.java.cmnguyen.problems.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxProfitIII {

    public static int maxProfit(int[] prices) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(3, Integer::compareTo);
        int curProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                curProfit += prices[i] - prices[i-1];
            } else if (curProfit != 0) {
                System.out.println("heap " + Arrays.toString(heap.toArray()) + " i=" + i + " value=" + prices[i] + " cur=" + curProfit);
                heap.offer(curProfit);
                if (heap.size() > 2) heap.poll();
                curProfit = 0;
            }
        }
        if (curProfit != 0) heap.offer(curProfit);
        System.out.println("heap " + Arrays.toString(heap.toArray()));

        int result = 0;
        for (int i=0; !heap.isEmpty() && i < 2; i++) result += heap.poll();
        return result;
    }
}
