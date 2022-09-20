package main.java.cmnguyen.problems.easy;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int min = prices[0];
        int max;
        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max = prices[i];
                result = Math.max(result, max - min);
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }

        return result;

    }

}
