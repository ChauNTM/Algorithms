package main.java.cmnguyen.problems.medium.binary_search;

public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            if (nums[mid] == target) return true;

            if (nums[mid] > nums[hi]) {
                if (target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            } else if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid;
            } else {
                if (nums[hi] == target) return true;
                hi--;
            }
        }

        return false;
    }

}
