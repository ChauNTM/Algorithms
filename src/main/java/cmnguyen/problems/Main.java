package main.java.cmnguyen.problems;

import main.java.cmnguyen.problems.easy.PalindromeNumber;
import main.java.cmnguyen.problems.easy.TwoSum;

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

}
