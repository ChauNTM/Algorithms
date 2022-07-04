package main.java.cmnguyen.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        return permute(nums, nums.length);
    }

    private static List<List<Integer>> permute(int[] nums, int n) {
        // append nums[n-1] to the last pos in call[n-1]
        if (n == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>(List.of(nums[0])));
            return result;
        }
        List<List<Integer>> pre = permute(nums, n-1);

        int length = pre.size();
        for (int i = 0; i < length; i++) {
            pre.get(i).add(nums[n-1]);
            for (int k = 0; k < n - 1; k++) {
                List<Integer> list = new ArrayList<>(pre.get(i));
                swap(list, k, n-1);
                pre.add(list);
            }
        }


        return pre;
    }

    private static void swap(List<Integer> arrays, int i, int j) {
        Integer temp = arrays.get(i);
        arrays.set(i, arrays.get(j));
        arrays.set(j, temp);
    }

}
