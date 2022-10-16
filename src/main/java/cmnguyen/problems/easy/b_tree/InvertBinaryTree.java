package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
