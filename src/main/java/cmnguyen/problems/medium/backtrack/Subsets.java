package main.java.cmnguyen.problems.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int i=0; i < nums.length; i++) {
            int length = result.size();
            for (int j = 0; j < length; j++) {
                List<Integer> list = new ArrayList<>(result.get(j));
                list.add(nums[i]);
                result.add(list);
            }
        }

        return result;
    }
}
