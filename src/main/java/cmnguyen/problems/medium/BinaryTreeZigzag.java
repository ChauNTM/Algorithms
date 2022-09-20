package main.java.cmnguyen.problems.medium;


import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.*;

public class BinaryTreeZigzag {

//    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        if (root == null) return List.of();
//        List<List<Integer>> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> stack1 = new Stack<>();
//        stack.push(root);
//
//        while (!stack.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            while(!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                list.add(node.val);
//                if (node.left != null) stack1.push(node.left);
//                if (node.right != null) stack1.push(node.right);
//            }
//            if (!list.isEmpty()) result.add(list);
//            List<Integer> list1 = new ArrayList<>();
//            while(!stack1.isEmpty()) {
//                TreeNode node = stack1.pop();
//                list1.add(node.val);
//                if (node.right != null) stack.push(node.right);
//                if (node.left != null) stack.push(node.left);
//            }
//            if (!list1.isEmpty()) result.add(list1);
//        }
//
//        return result;
//
//    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        zigzagTraverse(root, result, 0);
        return result;
    }

    private static void zigzagTraverse(TreeNode node, List<List<Integer>> values, int level) {
        if (node == null) return;

        if (values.size() <= level) {
            values.add(new ArrayList<>());
        }
        if (level % 2 == 0){
            values.get(level).add(node.val);
        } else {
            values.get(level).add(0, node.val);
        }
        zigzagTraverse(node.left, values, level + 1);
        zigzagTraverse(node.right, values, level + 1);
    }
}
