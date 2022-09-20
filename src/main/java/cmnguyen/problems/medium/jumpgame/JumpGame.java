package main.java.cmnguyen.problems.medium.jumpgame;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {
    /**
     * Solution is base on the observation: if we want to jump to index i, we have to go through i - 1
     * so we start from last index and every time we can jump from index i to last_pos
     * we can set last_pos to i
     * */
    public static boolean canJump(int[] nums) {
        int last_pos = nums.length - 1;
        for (int i = nums.length - 2; i >=0; i--) {
            if (i + nums[i] >= last_pos)
                last_pos = i;
        }
        return last_pos == 0;
    }
}
