package main.java.cmnguyen.problems.medium.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(result, list, 0, nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int start, int[] nums) {
        list.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            backtrack(list, temp, i + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
