package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class MaximumDepth {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        return Math.max(left, right);
    }
}
