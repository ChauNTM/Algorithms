package main.java.cmnguyen.problems.contest315;

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveInteger {

    public int findMaxK(int[] nums) {
        int res = -1;
        Set<Integer> map = new HashSet<>();

        for (int i=0; i < nums.length; i++) {
            map.add(nums[i]);
            if (map.contains(-nums[i])) {
                res = Math.max(Math.abs(nums[i]), res);
            }
        }

        return res;
    }
}
