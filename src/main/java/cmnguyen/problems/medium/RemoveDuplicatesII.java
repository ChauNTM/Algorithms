package main.java.cmnguyen.problems.medium;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * */
public class RemoveDuplicatesII {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k] || nums[i] != nums[k-1]) {
                nums[k++] = nums[i];
            }
        }

        return k + 1;
    }
}
