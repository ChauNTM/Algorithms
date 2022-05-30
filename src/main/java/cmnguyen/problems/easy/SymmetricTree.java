package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.TreeNode;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * */

public class SymmetricTree {

    static private String print(TreeNode node) {
        if (node == null) return "";
        return node.val + " " + print(node.left) + " " + print(node.right);
    }

    static public String println(TreeNode root) {
        return print(root);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right != null && left.val == right.val) {
            boolean leftCompare = isSymmetric(left.left, right.right);
            boolean rightCompare = isSymmetric(left.right, right.left);
            return leftCompare && rightCompare;
        } else {
            return false;
        }
    }
}
