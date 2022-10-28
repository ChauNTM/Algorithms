package main.java.cmnguyen.problems.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) temp.add(num);
        backtrack(temp, result, 0);
        return result;
    }
    private static void backtrack(List<Integer> nums, List<List<Integer>> result, int i) {
        if (i == nums.size()) {
            result.add(nums);
        }
        for (int j = i; j < nums.size(); j++) {
            if (j == i || nums.get(j) != nums.get(i)) {
                swap(nums, i, j);
                backtrack(new ArrayList<>(nums), result, i + 1);
            }
        }
    }

    private static void swap(List<Integer> arrays, int i, int j) {
        Integer temp = arrays.get(i);
        arrays.set(i, arrays.get(j));
        arrays.set(j, temp);
    }
}
