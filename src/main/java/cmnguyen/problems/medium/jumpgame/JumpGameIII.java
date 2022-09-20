package main.java.cmnguyen.problems.medium.jumpgame;

import java.util.ArrayDeque;
import java.util.Queue;

public class JumpGameIII {

    public static boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] marked = new boolean[arr.length];
        queue.add(start);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (arr[i] == 0) return true;
            marked[i] = true;
            int right = i + arr[i];
            if (right < arr.length && !marked[right]) {
                queue.add(right);
            }
            int left = i - arr[i];
            if (left >= 0 && !marked[left]) {
                queue.add(left);
            }
        }

        return false;
    }

}
