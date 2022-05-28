package main.java.cmnguyen.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * */

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        // First, we will sort the input
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int k=0; k<=nums.length-3; k++) {
            if (k > 0 && nums[k] == nums[k-1]) continue;
            int i = k+1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                }
                else if (sum < 0) {
                    i++;
                }
                else {
                    result.add(List.of(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while(i < j && j < nums.length-1 && nums[j] == nums[j+1]) j--;
                    while(i < j && i > 1 && nums[i] == nums[i-1]) i++;
                }


            }
        }
        return result;
    }
}
