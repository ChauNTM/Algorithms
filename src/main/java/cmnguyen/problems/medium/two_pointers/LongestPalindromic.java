package main.java.cmnguyen.problems.medium.two_pointers;

/**
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * */
public class LongestPalindromic {

//    public static String longestPalindrome(String s) {
//        int n = s.length();
//        if (n == 1) return s;
//        int left = 0;
//        int right = 0;
//        int maxLength = 0;
//        for (int i = 1; i < n; i++) {
//            int length = palindrome(s, i -1, i + 1);
//            if (maxLength < length) {
//                maxLength = length;
//                left = i - length / 2;
//                right = i + length / 2;
//            }
//            length = palindrome(s, i - 1, i);
//            if (maxLength < length) {
//                maxLength = length;
//                left = i - length / 2;
//                right = i + length / 2 - 1;
//            }
//        }
//        return s.substring(left, right + 1);
//    }
//
//    private static int palindrome(String s, int i, int j) {
//        int n = s.length();
//        while(i >= 0 && j < n) {
//            if (s.charAt(i) != s.charAt(j)) break;
//            i--;
//            j++;
//        }
//        i++;
//        j--;
//        return (j - i + 1);
//    }

    public static String longestPalindrome(String str) {
        if (str.length() == 1) return str;

        String result = "";

        for (int i=1; i < str.length(); i++) {
            String oddPalindromic = findPalindromic(str, i, true);
            if (result.isEmpty() || oddPalindromic.length() > result.length())
                result = oddPalindromic;

            String evenPalindromic = findPalindromic(str, i, false);

            if (result.isEmpty() || evenPalindromic.length() > result.length())
                result = evenPalindromic;

        }

        return result;
    }

    private static String findPalindromic(String str, int i, boolean isOdd) {
        int start = i-1;
        int end = isOdd ? (i + 1) : i;
        while ((start >= 0 && end < str.length()) &&
                str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }
        return str.substring(start + 1, end);
    }
}
