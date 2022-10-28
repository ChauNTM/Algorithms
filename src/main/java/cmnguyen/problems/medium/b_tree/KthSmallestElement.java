package main.java.cmnguyen.problems.medium.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

public class KthSmallestElement {

    // this solution takes O(n2) in worst case if the BST is unbalanced and lean left, Ex:
    //    9
    //   /
    //  8
    // /
    //7
    // In best case, it takes O(n)
//    public int kthSmallest(TreeNode root, int k) {
//        if (root == null) return 0;
//        int size = size(root.left);
//        if (size > k-1) return kthSmallest(root.left, k);
//        else if (size < k-1) return kthSmallest(root.right, k - 1 - size);
//        else return root.val;
//    }
//
//    private int size(TreeNode node) {
//        if (node == null) return 0;
//
//        return 1 + size(node.left) + size(node.right);
//    }

    int count = 0;
    int number = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        findKthSmallest(root);
        return number;
    }

    private void findKthSmallest(TreeNode node) {
        if (node == null) return;
        findKthSmallest(node.left);
        count--;
        if (count == 0) {
            number = node.val;
            return;
        }
        findKthSmallest(node.right);
    }

}
