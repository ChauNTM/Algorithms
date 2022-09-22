package main.java.cmnguyen.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

//    public static int climbStairs(int n) {
//        return backtrack(n, new HashMap<>());
//    }
//
//    private static int backtrack(int n, HashMap<Integer, Integer> previous) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        System.out.println();
//        if (previous.containsKey(n)) return previous.get(n);
//
//        int count =  backtrack(n - 1, previous) +  backtrack(n - 2, previous);
//        previous.put(n, count);
//        return count;
//    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i - 2];
        }
        return dp[n];
    }
}
