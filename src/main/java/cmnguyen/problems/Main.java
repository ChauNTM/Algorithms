package main.java.cmnguyen.problems;

import com.sun.source.tree.Tree;
import main.java.cmnguyen.problems.easy.*;
import main.java.cmnguyen.problems.medium.AddTwoNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testSymmetricTree();
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

        AddTwoNumbers.ListNode l1 = fromArray(arr1);
        AddTwoNumbers.ListNode l2 = fromArray(arr2);
        System.out.println("list 1 " + l1);
        System.out.println("list 2 " + l2);
        System.out.println("sum " + AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    static private AddTwoNumbers.ListNode fromArray(int[] arr) {
        AddTwoNumbers.ListNode head = null;
        AddTwoNumbers.ListNode tail = null;
        for (int j : arr) {
            if (head == null) {
                head = new AddTwoNumbers.ListNode(j);
                tail = head;
            } else {
                System.out.println("tail.next" + tail.val);
                tail.next = new AddTwoNumbers.ListNode(j);
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
        SymmetricTree.TreeNode node = SymmetricTree.initBinaryTree(arrays);
        System.out.println("Binary tree: " + SymmetricTree.println(node));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node));

        List<Integer> arrays1 = Arrays.asList(1,2,2,3,4,4,3,5,6,7,null,null,7,6,5,9);
        SymmetricTree.TreeNode node1 = SymmetricTree.initBinaryTree(arrays1);
        System.out.println("Binary tree: " + SymmetricTree.println(node1));
        System.out.println("is Symmetric " + SymmetricTree.isSymmetric(node1));

    }

}
