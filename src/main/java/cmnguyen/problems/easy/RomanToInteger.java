package main.java.cmnguyen.problems.easy;

/** Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Given a roman numeral, convert it to an integer.
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Constraints:
 * - 1 <= s.length <= 15
 * - s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * - It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        int n = s.length() - 1;
        int value = roman(s.charAt(n));
        // Optimize by using extra previous variable to save previous converted roman.
        // save 1 more extra switch case check
        int previous = value;
        for (int i = n; i >= 1; i--) {
            int current = roman(s.charAt(i-1));
            if (current < previous) {
                value -= current;
            } else {
                value += current;
            }
            previous = current;
        }

        return value;
    }

    private static int roman(Character i) throws IllegalArgumentException {
        switch (i) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: throw new IllegalArgumentException("not have an roman integer");
        }
    }
}
