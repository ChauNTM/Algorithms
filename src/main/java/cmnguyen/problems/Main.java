package main.java.cmnguyen.problems;

import main.java.cmnguyen.problems.easy.*;
import main.java.cmnguyen.problems.medium.*;
import main.java.cmnguyen.problems.structure.ListNode;
import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        reverseInteger();
    }

    private static void testPalindromeNumber() {
        PalindromeNumber algo = new PalindromeNumber();
        System.out.println("algo.isPalindrome(121)=" + algo.isPalindrome(121));
        System.out.println("algo.isPalindrome(23456)=" + algo.isPalindrome(23456));
        System.out.println("algo.isPalindrome(23432)=" + algo.isPalindrome(23432));
        System.out.println("algo.isPalindrome(1001)=" + algo.isPalindrome(1001));
    }

    private static void testTwoSum() {
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

    private static void testTwoNumbers() {
        int[] arr1 = new int[] {9,9,9,9,9,9,9};
        int[] arr2 = new int[] {9,9,9,9};

        ListNode l1 = fromArray(arr1);
        ListNode l2 = fromArray(arr2);
        System.out.println("list 1 " + l1);
        System.out.println("list 2 " + l2);
        System.out.println("sum " + AddTwoNumbers.addTwoNumbers(l1, l2));
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

    static private void testRomanToInteger() {
        String roman = "MMMCMXCIX";
        System.out.println("integer from roman " + RomanToInteger.romanToInt(roman));
    }

    static private void testValidParentheses() {
        String str = "{[]}{{{()[]}}}";
        System.out.println("result " + ValidParentheses.isValid(str));
    }

    static private void testSymmetricTree() {
        List<Integer> arrays = Arrays.asList(1,2,2,null,3,null,3);
        TreeNode node = TreeNode.initBinaryTree(arrays);
        System.out.println("Binary tree: " + SymmetricTree.println(node));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node));

        List<Integer> arrays1 = Arrays.asList(1,2,2,3,4,4,3,5,6,7,null,null,7,6,5);
        TreeNode node1 = TreeNode.initBinaryTree(arrays1);
        System.out.println("Binary tree: " + SymmetricTree.println(node1));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node1));

    }

    static void testSqrt() {
        int x = 2147395599;
        System.out.println("Sqrt(" + x + ") = " + Sqrt.mySqrt(x));
    }

    static private void testSameTree() {
        List<Integer> arrays = Arrays.asList(1,2);
        TreeNode p = TreeNode.initBinaryTree(arrays);

        List<Integer> arrays1 = Arrays.asList(1,2);
        TreeNode q = TreeNode.initBinaryTree(arrays1);

        System.out.println("Are the same trees: " + SameTree.isSameTree(p, q));

    }

    static private void testPathSum() {
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

    static private void test3Sum() {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = ThreeSum.threeSumHashMap(nums);
        System.out.println("Result: " + result);

        nums = new int[]{0,0,0,0};
        System.out.println("Result: " + ThreeSum.threeSumHashMap(nums));

        nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println("Result: " + ThreeSum.threeSumHashMap(nums));

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(-1);
        list1.add(1);

        System.out.println("hashcode: " + List.of(-1, 1, 0).hashCode() + " hashcode2 = " + list1.hashCode());
    }

    static private void test4Sum() {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> result = FourSum.fourSum(nums, 0);
        System.out.println("Result: " + result);

        nums = new int[]{2,2,2,2,2};
        System.out.println("Result: " + FourSum.fourSum(nums, 8));

    }

    static private void removeNthNode() {
        int[] arr1 = new int[] {1,2,3,4,5};
        int[] arr2 = new int[] {1};
        int[] arr3 = new int[] {1, 2};

        ListNode l1 = fromArray(arr1);
        ListNode l2 = fromArray(arr2);
        ListNode l3 = fromArray(arr3);
        System.out.println("list 1 " + RemoveNthNode.removeNthFromEnd2Pointers(l1, 2));
        System.out.println("list 2 " + RemoveNthNode.removeNthFromEnd2Pointers(l2, 1));
        System.out.println("list 3 " + RemoveNthNode.removeNthFromEnd2Pointers(l3, 2));
    }

    static private void reverseInteger() {
//        int number = -123;
//        System.out.println("reverse integer: " + ReverseInteger.reverse(number));

        int number = 1534236469;
        System.out.println("reverse integer: " + ReverseInteger.reverse(number));

        number = -2147483412;
        System.out.println("reverse integer: " + ReverseInteger.reverse(number));
    }

}
