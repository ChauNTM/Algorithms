package main.java.cmnguyen.problems.medium.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(candidates, new ArrayList<>(), res, target, 0, 0);
        return res;
    }

    public static void combinationSum(int[] candidates, List<Integer> temp,
                                              List<List<Integer>> res, int target, int sum, int i) {
        if (target == sum) {
            res.add(temp);
        }

        for (int j = i; j < candidates.length; j++) {
            if (sum + candidates[j] > target) continue;
            temp.add(candidates[j]);
            combinationSum(candidates, new ArrayList<>(temp), res, target, sum + candidates[j], j);
            temp.remove(temp.size() - 1);
        }
    }

}
