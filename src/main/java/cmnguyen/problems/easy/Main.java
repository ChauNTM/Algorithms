package main.java.cmnguyen.problems.easy;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testPalindromeNumber();
    }

    private static void testPalindromeNumber() {
        PalindromeNumber algo = new PalindromeNumber();
        System.out.println("algo.isPalindrome(121)=" + algo.isPalindrome(121));
        System.out.println("algo.isPalindrome(23456)=" + algo.isPalindrome(23456));
        System.out.println("algo.isPalindrome(23432)=" + algo.isPalindrome(23432));
        System.out.println("algo.isPalindrome(1001)=" + algo.isPalindrome(1001));
    }

    private static void twoSum() {
        int[] a = new int[]{3, 3};
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

}
