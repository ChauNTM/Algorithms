package main.java.cmnguyen.problems.easy;

/**
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * */

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int palindrome = 0;
        int input = x;
        while (input != 0) {
            palindrome = palindrome * 10 + (input % 10);
            input = input / 10;
        }

        return palindrome == x;
    }
}
