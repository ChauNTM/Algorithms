package main.java.cmnguyen.problems.medium.kadane;

public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int previous = nums[0];

        for (int i = 1; i < nums.length; i++) {
            previous = Math.max(previous + nums[i], nums[i]);
            if (previous > result) result = previous;
        }

        return result;
    }
}
