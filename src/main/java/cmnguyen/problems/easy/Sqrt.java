package main.java.cmnguyen.problems.easy;
/**
 * Given a non-negative integer x, compute and return the square root of x.
 * Since the return type is an integer, the decimal digits are truncated,
 * and only the integer part of the result is returned.
 *
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
**/
public class Sqrt {
    // Using binary search, find result between 1 -> x/2
    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int lo = 0;
        int hi = x;
        int mid = 1;

        while (lo <= hi) {
            mid = lo + (hi - lo)/2;
            // integer overflow if we compare mid*mid with x, so we will take x/mid to compare to mid instead
            int result = x / mid;
            if (result == mid) return mid;
            else if (mid > result) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        if (mid > x/mid) mid--;
        return mid;
    }
}
