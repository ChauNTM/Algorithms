package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryTreePaths(root, paths, "");
        return paths;
    }

    private static void binaryTreePaths(TreeNode node, List<String> paths, String pre) {
        if (node.left == null && node.right == null) {
            paths.add(pre + node.val);
            return;
        }
        if (node.left != null)
            binaryTreePaths(node.left, paths, pre + node.val + "->");
        if (node.right != null)
            binaryTreePaths(node.right, paths, pre + node.val + "->");
    }


}
