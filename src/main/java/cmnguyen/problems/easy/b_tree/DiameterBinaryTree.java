package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class DiameterBinaryTree {
    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return max;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;

    }
}
