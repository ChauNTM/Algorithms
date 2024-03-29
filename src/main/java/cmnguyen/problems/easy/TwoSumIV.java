package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.HashSet;

public class TwoSumIV {

//    public static boolean findTarget(TreeNode root, int k) {
//        if (root == null) return false;
//
//        return findTarget(root, root, k);
//    }
//
//    private static boolean findTarget(TreeNode root, TreeNode node, int k) {
//        if (node == null) return false;
//
//        return (k - node.val != node.val && find(root, k - node.val)) || findTarget(root, node.left, k)
//                || findTarget(root, node.right, k);
//    }
//
//    public static boolean find(TreeNode node, int val) {
//        if (node == null) return false;
//        if (val == node.val) return true;
//        else if (val < node.val) return find(node.left, val);
//        else return find(node.right, val);
//    }

    public static boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        HashSet<Integer> hashSet = new HashSet<>();
        return dfs(root, hashSet, k);
    }

    public static boolean dfs(TreeNode node, HashSet<Integer> hashSet, int k) {
        if (node == null) return false;
        if (hashSet.contains(k - node.val)) return true;
        hashSet.add(node.val);
        return dfs(node.left, hashSet, k) || dfs(node.right, hashSet, k);
    }

}
