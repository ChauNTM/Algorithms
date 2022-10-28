package main.java.cmnguyen.problems.medium.binary_search;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            } else {
                if (target < nums[mid] && target >= nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            }
        }

        return -1;
    }

//    public  int search(int[] nums, int target) {
//        int lo = 0;
//        int hi = nums.length - 1;
//        int mid = 0;
//
//        while (lo < hi) {
//            mid = lo + (hi - lo)/2;
//            if (mid == nums.length-1 || nums[mid] > nums[mid + 1]) break;
//            if (nums[mid] > nums[hi]) lo = mid + 1;
//            else hi = mid;
//        }
//        if (nums[mid] == target) return mid;
//
//        lo = 0;
//        hi = nums.length - 1;
//        if (target <= nums[hi]) {
//            lo = mid + 1;
//        } else {
//            hi = mid;
//        }
//        while(lo <= hi) {
//            mid = lo + (hi - lo)/2;
//            if (nums[mid] == target)return mid;
//            if (target < nums[mid]) hi = mid - 1;
//            else lo = mid + 1;
//        }
//
//        return -1;
//    }

}
