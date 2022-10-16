package main.java.cmnguyen.problems.contest315;

import java.util.HashSet;
import java.util.Set;

public class CountNumberDistinctInteger {

    public static void main(String[] args) {
        int[] nums = {1,13,10,12,31};
        System.out.println("count=" + countDistinctIntegers(nums));
    }

    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for (int i=0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                count++;
                set.add(nums[i]);
            }
            int reverse = reverseInteger(nums[i]);
            if (!set.contains(reverse)) {
                count++;
                set.add(reverse);
            }
        }

        return count;
    }

    private static int reverseInteger(int num) {
        int res = 0;
        while(num != 0) {
            res = 10*res + num % 10;
            num /= 10;
        }

        return res;
    }
}
