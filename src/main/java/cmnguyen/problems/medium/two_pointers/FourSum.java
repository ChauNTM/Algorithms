package main.java.cmnguyen.problems.medium.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 * */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i=0; i<nums.length-3; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            result.addAll(threeSum(nums, i+1, nums[i], target - nums[i]));
        }

        return result;
    }

    private static List<List<Integer>> threeSum(int[] nums, int start, int firstNum, int target) {
        List<List<Integer>> result = new ArrayList<>();

        for (int k=start; k<nums.length-2; k++) {
            if (k > start && nums[k] == nums[k-1]) continue;
            int i = k+1;
            int j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == target) {
                    result.add(List.of(firstNum, nums[k], nums[i++], nums[j--]));
                    while (i < j && i > 0 && nums[i] == nums[i-1]) i++;
                    while (i < j && j < nums.length - 1 && nums[j] == nums[j+1]) j--;
                } else if (sum > target){
                    j--;
                    while (i < j && j < nums.length - 1 && nums[j] == nums[j+1]) j--;
                } else {
                    i++;
                    while (i < j && i > 0 && nums[i] == nums[i-1]) i++;
                }
            }
        }

        return result;
    }

}
