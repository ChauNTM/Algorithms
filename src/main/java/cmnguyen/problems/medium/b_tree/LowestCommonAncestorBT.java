package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class LowestCommonAncestorBT {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null? left : root;

    }

}
