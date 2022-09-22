package main.java.cmnguyen.problems.easy;

import com.sun.source.tree.Tree;
import main.java.cmnguyen.problems.structure.ListNode;
import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        middleOfLinkedList();
    }

    private static void testPalindromeNumber() {
        PalindromeNumber algo = new PalindromeNumber();
        System.out.println("algo.isPalindrome(121)=" + algo.isPalindrome(121));
        System.out.println("algo.isPalindrome(23456)=" + algo.isPalindrome(23456));
        System.out.println("algo.isPalindrome(23432)=" + algo.isPalindrome(23432));
        System.out.println("algo.isPalindrome(1001)=" + algo.isPalindrome(1001));
    }

    private static void twoSum() {
        int[] a = new int[]{3, 2, 4};
        int target = 6;
        TwoSum algo = new TwoSum();
        int[] result = algo.twoSum(a, target);
        if (result.length == 0) {
            System.out.println("No result");
        }
        else {
            System.out.println("2 sum with target " + target + ": {" + result[0] + ", " + result[1] + "}");
        }
    }

    static private void romanToInteger() {
        String roman = "MMMCMXCIX";
        System.out.println("integer from roman " + RomanToInteger.romanToInt(roman));
    }

    static private void validParentheses() {
        String str = "{[]}{{{()[]}}}";
        System.out.println("result " + ValidParentheses.isValid(str));
    }

    static private void symmetricTree() {
        List<Integer> arrays = Arrays.asList(1,2,2,null,3,null,3);
        TreeNode node = TreeNode.initBinaryTree(arrays);
        System.out.println("Binary tree: " + SymmetricTree.println(node));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node));

        List<Integer> arrays1 = Arrays.asList(1,2,2,3,4,4,3,5,6,7,null,null,7,6,5);
        TreeNode node1 = TreeNode.initBinaryTree(arrays1);
        System.out.println("Binary tree: " + SymmetricTree.println(node1));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node1));

    }

    static void sqrt() {
        int x = 2147395599;
        System.out.println("Sqrt(" + x + ") = " + Sqrt.mySqrt(x));
    }

    static private void isTheSameTree() {
        List<Integer> arrays = Arrays.asList(1,2);
        TreeNode p = TreeNode.initBinaryTree(arrays);

        List<Integer> arrays1 = Arrays.asList(1,2);
        TreeNode q = TreeNode.initBinaryTree(arrays1);

        System.out.println("Are the same trees: " + SameTree.isSameTree(p, q));

    }

    static private void pathSum() {
        List<Integer> arrays = Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1);
        TreeNode p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree has path sum: " + PathSum.hasPathSum(p, 22));

        arrays = Arrays.asList(1);
        p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree has path sum: " + PathSum.hasPathSum(p, 1));

        arrays = Arrays.asList(1, 2);
        p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree has path sum: " + PathSum.hasPathSum(p, 1));

        arrays = Arrays.asList(1,2,null,3,null,4,null,5);
        p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree has path sum: " + PathSum.hasPathSum(p, 6));
    }

    private static void reverseLinkedList() {
        int[] arr = {1,2,3,4,5};
        ListNode head = fromArray(arr);
        System.out.println(ReverseLinkedList.reverseList(head));
    }

    static private ListNode fromArray(int[] arr) {
        ListNode head = null;
        ListNode tail = null;
        for (int j : arr) {
            if (head == null) {
                head = new ListNode(j);
                tail = head;
            } else {
                tail.next = new ListNode(j);
                tail = tail.next;
            }
        }
        return head;
    }

    private static void climbingStair() {
        int n = 6;
        System.out.println("There are " + ClimbingStairs.climbStairs(n) + " ways to climb to the top");
    }

    private static void maxProfit() {
        int[] prices = new int[] {7,1,5,3,6,4,7};
        System.out.println("max profit: " + MaxProfit.maxProfit(prices));
    }

    private static void balancedBinaryTree() {
        List<Integer> arrays = Arrays.asList(1,null,2,null,3);
        TreeNode p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree is balanced " + BalancedBinaryTree.isBalanced(p));
    }

    private static void maxDepth() {
        List<Integer> arrays = Arrays.asList(1,null,2,null,3);
        TreeNode p = TreeNode.initBinaryTree(arrays);
        System.out.println("Tree is balanced " + MaximumDepth.maxDepth(p));
    }

    private static void twoSumIV() {
        List<Integer> arrays = Arrays.asList(2,1,3);
        TreeNode p = TreeNode.initBinaryTree(arrays);
        int target = 4;
        System.out.println("Exist two elements in the BST such that their sum is equal to the given target "
                + TwoSumIV.findTarget(p, target));
    }

    private static void validAnagram() {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(t + " is " + (!ValidAnagram.isAnagram(s, t) ? "not " : "") + "a valid anagram of " + t);
    }

    private static void majorityElement() {
        int[] nums = new int[]{2, 3, 3, 5, 3, 3, 4, 2};
        System.out.println("Majority element: " + MajorityElement.majorityElement(nums));
    }

    private static void floodFill() {
//        int[][] image = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int[][] image = new int[][]{{0,0,0},{0,0,0}};
        System.out.println("Flood fill " + Arrays.deepToString(FloodFill.floodFill(image, 0, 0, 0)));
    }

    private static void islandPerimeter() {
        int[][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
//        int[][] grid = new int[][]{{0,1}};
        System.out.println("Island perimeter " + IslandPerimeter.islandPerimeter(grid));
    }

    private static void invertBinaryTree() {
        List<Integer> arrays = Arrays.asList(4,2,7,1,3,6,9);
        TreeNode p = TreeNode.initBinaryTree(arrays);
        System.out.println("Invert binary tree " + TreeNode.println(InvertBinaryTree.invertTree(p)));
    }

    private static void middleOfLinkedList() {
        int[] arr = {1,2,3,4,5};
        ListNode head = fromArray(arr);
        System.out.println("Middle of linked list " + MiddleOfLinkedList.middleNode(head));
    }

}
