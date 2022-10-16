package main.java.cmnguyen.problems.medium.binary_search;

public class FindMinInRotatedSortedArrayII {

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while (lo < hi) {
            mid = lo + (hi - lo)/2;

            if (mid == nums.length - 1 || nums[mid] > nums[mid + 1]) {
                mid++;
                break;
            }
            if (nums[hi] < nums[mid]) lo = mid + 1;
            else if (nums[hi] > nums[mid]) hi = mid;
            else {
                hi--;
            }
        }

        return nums[mid];
    }

}
