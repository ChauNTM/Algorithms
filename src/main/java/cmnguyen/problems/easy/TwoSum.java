package main.java.cmnguyen.problems.easy;

import java.util.HashMap;
import java.util.Map;

/** Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 ** You may assume that each input would have exactly one solution, and you may not use the same element twice.
 ** You can return the answer in any order.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
***/

public class TwoSum {
    public int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            int number = target - a[i];
            if (hashMap.containsKey(number)) return new int[]{i, hashMap.get(number)};
            hashMap.put(a[i], i);
        }

        return new int[]{};
        
    }
}
