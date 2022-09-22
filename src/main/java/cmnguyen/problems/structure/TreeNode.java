package main.java.cmnguyen.problems.structure;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return "" + val;
    }

    static public TreeNode initBinaryTree(List<Integer> arr) {
        // Add dummy value to index 0, so that arrays values start from 1 to N
        ArrayList<Integer> arrays = new ArrayList<>(arr);
        arrays.add(0, 0);
        TreeNode[] nodes = new TreeNode[arrays.size()];
        for (int i=1; i<arrays.size(); i++) {
            Integer value = arrays.get(i);
            if (value != null) nodes[i] = new TreeNode(value);
            else nodes[i] = null;
        }

        for (int i=1; i<=nodes.length/2; i++) {
            if (nodes[i] != null) {
                if (2*i < nodes.length && arrays.get(2*i) != null) {
                    nodes[i].left = nodes[2*i];
                }
                if (2*i < nodes.length - 1 && arrays.get(2*i + 1) != null) {
                    nodes[i].right = nodes[2*i + 1];
                }

            }
        }
        return nodes[1];
    }

    static private String print(TreeNode node) {
        if (node == null) return "";
        return node.val + " " + print(node.left) + " " + print(node.right);
    }

    static public String println(TreeNode root) {
        return print(root);
    }
}
