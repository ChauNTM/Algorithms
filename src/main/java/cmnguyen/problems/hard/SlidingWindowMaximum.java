package main.java.cmnguyen.problems.hard;

import java.util.ArrayDeque;

/**
* You are given an array of integers nums, there is a sliding window of size k which is moving from
 * the very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
* */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int r = 0;

        for (int i=0; i < nums.length; i++) {
            // remove elements out of range [i-k, i]
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }

            queue.offer(i);
            if (i >= k - 1) result[r++] = nums[queue.peek()];

        }

        return result;
    }
}
