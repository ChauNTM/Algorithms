package main.java.cmnguyen.problems.hard;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDistinct {

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums,  k -1);
    }

    private static int atMost(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int i = 0;
        int res = 0;

        for (int j = 0; j < nums.length; j++) {
            count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);

            while(count.size() > k) {
                int c = count.get(nums[i]);
                if (c == 1) count.remove(nums[i++]);
                else count.put(nums[i++], c - 1);
            }

            res += j - i + 1;
        }

        return res;
    }
}
