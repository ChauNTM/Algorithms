package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class LongestUniValuePath {
    int maxLength = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        lengthOfPath(root, root.val);
        return maxLength;
    }

    private int lengthOfPath(TreeNode node, int parent) {
        if (node == null) return 0;

        int left = lengthOfPath(node.left, node.val);
        int right = lengthOfPath(node.right, node.val);
        maxLength = Math.max(left + right, maxLength);

        if (node.val == parent) return 1 + Math.max(left, right);

        return 0;
    }

}
