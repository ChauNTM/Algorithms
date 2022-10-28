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

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int i, int[] nums) {
        list.add(new ArrayList<>(temp));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]) continue;
            temp.add(nums[i]);
            backtrack(list, temp, j + 1, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
