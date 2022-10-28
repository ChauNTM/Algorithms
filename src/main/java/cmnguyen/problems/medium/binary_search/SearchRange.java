package main.java.cmnguyen.problems.medium.binary_search;

public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length, lo = 0, hi = n - 1;
        int[] result = new int[]{-1,-1};

        // find the first one
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] >= target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
        }
        if (lo < 0 || lo >= n || nums[lo] != target) return new int[]{-1,-1};
        result[0] = lo;

        hi = n - 1;
        // find the last one
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (nums[mid] <= target) lo = mid + 1;
            else if (nums[mid] > target) hi = mid - 1;
        }
        result[1] = hi;

        return result;
    }

}
