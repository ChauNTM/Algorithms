package main.java.cmnguyen.problems.medium.jumpgame;
/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * */
public class JumpGameII {

    public static int jump(int[] nums) {
        int minStep = 0;
        int currentJump = 0;
        int maxJump = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == currentJump) {
                minStep++;
                currentJump = maxJump;
            }
            if (currentJump >= nums.length - 1) return minStep;

        }
        return minStep;
    }
}
