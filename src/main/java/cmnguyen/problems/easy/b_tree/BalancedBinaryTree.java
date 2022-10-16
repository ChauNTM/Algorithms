package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int delta = findLevel(root.left) - findLevel(root.right);
        return Math.abs(delta) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int findLevel(TreeNode node) {
        if (node == null) return 0;
        int left = 1 + findLevel(node.left);
        int right = 1 + findLevel(node.right);
        return Math.max(left, right);
    }
}
