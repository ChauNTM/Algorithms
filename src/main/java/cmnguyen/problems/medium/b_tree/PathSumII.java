package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) return result;
//        pathSum(root, targetSum, result, new ArrayList<>(), 0);
//        return result;
//    }
//
//    private void pathSum(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> sum, int curSum) {
//        if (node.left == null && node.right == null) {
//            if (curSum + node.val == targetSum) {
//                sum.add(node.val);
//                result.add(new ArrayList<>(sum));
//            }
//            return;
//        }
//        sum.add(node.val);
//        if (node.left != null) {
//            pathSum(node.left, targetSum, result, new ArrayList<>(sum), curSum + node.val);
//        }
//        if (node.right != null) {
//            pathSum(node.right, targetSum, result, new ArrayList<>(sum), curSum + node.val);
//        }
//    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> sum) {
        if (node == null) return;

        sum.add(node.val);
        if (node.left == null && node.right == null && node.val == targetSum) {
            result.add(new ArrayList<>(sum));
        } else {
            pathSum(node.left, targetSum - node.val, result, sum);
            pathSum(node.right, targetSum - node.val, result, sum);
        }
        sum.remove(sum.size() - 1);
    }

}
