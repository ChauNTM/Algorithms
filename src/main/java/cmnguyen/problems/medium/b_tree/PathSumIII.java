package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> cache = new HashMap<>();
        cache.put(0l, 1);
        dfs(root, targetSum, 0, cache);
        return count;
    }

    private void dfs(TreeNode node, int targetSum, long curSum, Map<Long, Integer> cache) {
        if (node == null) return;

        curSum += node.val;
        long oldSum = curSum - targetSum;
        count += cache.getOrDefault(oldSum, 0);
        cache.put(curSum, cache.getOrDefault(curSum, 0) + 1);

        dfs(node.left, targetSum, curSum, cache);
        dfs(node.right, targetSum, curSum, cache);

        cache.put(curSum, cache.get(curSum) - 1);
    }

//    public int pathSum(TreeNode root, int targetSum) {
//        if (root == null) return 0;
//        dfs(root, targetSum);
//        return count;
//    }
//
//    private void dfs(TreeNode node, int targetSum) {
//        if (node == null) return;
//        count += countSum(node, targetSum);
//        dfs(node.left, targetSum);
//        dfs(node.right, targetSum);
//    }
//
//    private int countSum(TreeNode node, long targetSum) {
//        if (node == null) return 0;
//
//        return (node.val == targetSum ? 1 : 0) +
//                countSum(node.left, targetSum - node.val)
//                + countSum(node.right, targetSum - node.val);
//    }

}
