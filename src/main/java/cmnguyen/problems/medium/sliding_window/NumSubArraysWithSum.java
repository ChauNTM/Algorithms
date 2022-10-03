package main.java.cmnguyen.problems.medium.sliding_window;

public class NumSubArraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal);
    }

    /**
     * 1. atMost(S) = sum 0 to sum S, atMost(S-1) = sum 0 to sum S-1
     * 2. j-i+1 is the count of valid subarrays found
     * */
    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;
        int i = 0;
        int res = 0;

        for (int j=0; j < nums.length; j++) {
            goal -= nums[j];
            while (goal < 0) goal += nums[i++];
            res += j - i + 1;
        }

        return res;
    }
}
