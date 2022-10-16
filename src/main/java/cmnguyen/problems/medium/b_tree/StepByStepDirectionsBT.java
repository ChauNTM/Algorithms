package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class StepByStepDirectionsBT {
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();

        findPath(root, startValue, start);
        findPath(root, destValue, dest);

        int i = 0;
        int n = Math.min(start.length(), dest.length());
        while(i < n && start.charAt(start.length() - i - 1) == dest.charAt(dest.length() - i - 1)) i++;

        return "U".repeat(start.length() - i) + dest.reverse().substring(i);
    }

    private static boolean findPath(TreeNode node, int value, StringBuilder builder) {
        if (node.val == value) {
            return true;
        }

        if (node.left != null && findPath(node.left, value, builder)) {
            builder.append('L');
        }
        else if (node.right != null && findPath(node.right, value, builder)) {
            builder.append('R');
        }

        return !builder.isEmpty();
    }

}
