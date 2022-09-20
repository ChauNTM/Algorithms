package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.TreeNode;

public class TwoSumIV {

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        if (k > root.val) {
            return find(root.left, k - root.val) || find(root.right, k - root.val);
        } else {
            return findTarget(root.left, k);
        }
    }

    private static boolean find(TreeNode node, int k) {
        if (node == null) return false;
        if (node.val == k) return true;
        if (k < node.val) return find(node.left, k);
        else return find(node.right, k);
    }

}
