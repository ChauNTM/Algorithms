package main.java.cmnguyen.problems.medium.sliding_window;

public class MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int n = nums.length;
        int res = n + 1;

        for (int j = 0; j < nums.length; j++) {
            target -= nums[j];

            while (target <= 0) {
                res = Math.min(res, j - i + 1);
                target += nums[i++];
            }
        }

        if (res == Integer.MAX_VALUE) return 0;

        return res % (n + 1);
    }

}
