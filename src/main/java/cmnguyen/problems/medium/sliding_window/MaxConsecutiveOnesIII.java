package main.java.cmnguyen.problems.medium.sliding_window;

public class MaxConsecutiveOnesIII {

    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) k--;

            if (k < 0) {
                // Actually, we don't need to result variable, we can return j-i instead
                // because when the window is invalid, both i and j are increase together,
                // so that the previous valid window size is unchanged until we get a new valid window again.
                // we don't need result = Math.max(result, j - i) too, because result will never get down
                // only 2 cases: both i and j are increase together by 1, or j increase, i is unchanged.
                result = j - i;
                if (nums[i++] == 0) k++;
            } else {
                result++;
            }
        }

        return result;
    }
}
