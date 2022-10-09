package main.java.cmnguyen.problems.medium.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MaximumErasureValue {

    public static int maximumUniqueSubarray(int[] nums) {
        int i = 0, j;
        Map<Integer, Integer> ids = new HashMap<>();
        int[] sum = new int[nums.length];
        int max = 0;

        for (j = 0; j < nums.length; j++) {
            int id = ids.getOrDefault(nums[j], -1);
            sum[j] = j > 0 ? sum[j-1] + nums[j] : nums[j];
            if (id > -1 && id >= i) {
                max = Math.max(max, sum[j - 1] - sum[i] + nums[i]);
                i = id + 1;
            }
            ids.put(nums[j], j);
        }
        max = Math.max(max, sum[j-1] - sum[i] + nums[i]);

        return max;
    }

}
