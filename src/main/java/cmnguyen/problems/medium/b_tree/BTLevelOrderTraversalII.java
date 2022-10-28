package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BTLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderBottom(root, res, 1);
        return res;
    }

    private void levelOrderBottom(TreeNode root, List<List<Integer>> elements, int level) {
        if (root == null) return;

        if (level > elements.size()) {
            elements.add(0, new ArrayList<>());
        }
        elements.get(elements.size() - level).add(root.val);

        levelOrderBottom(root.left, elements, level + 1);
        levelOrderBottom(root.right, elements, level + 1);
    }

}
