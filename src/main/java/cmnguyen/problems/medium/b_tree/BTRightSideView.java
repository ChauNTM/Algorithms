package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.*;

public class BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        rightSideView(root, nodes, 1);
        return nodes;
    }

    private void rightSideView(TreeNode node, List<Integer> nodes, int level) {
        if (node == null) return;
        if (level > nodes.size()) nodes.add(node.val);
        rightSideView(node.right, nodes, level + 1);
        rightSideView(node.left, nodes, level + 1);
    }

}
