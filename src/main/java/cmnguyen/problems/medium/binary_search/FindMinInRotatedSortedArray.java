package main.java.cmnguyen.problems.medium.binary_search;

public class FindMinInRotatedSortedArray {

    public static int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo)/2;
            if (mid == nums.length - 1 || nums[mid] > nums[mid +1]) {
                mid = Math.min(mid + 1, nums.length-1);
                break;
            }
            if (nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }


        return nums[mid];
    }

}
