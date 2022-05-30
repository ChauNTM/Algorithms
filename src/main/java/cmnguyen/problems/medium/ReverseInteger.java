package main.java.cmnguyen.problems.medium;


/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * Solve number overflow problem
 *
 * input: 1534236469
 * expected output: 0
 * */
public class ReverseInteger {
    public static int reverse(int x) {
        if (x < 0) return - reversePositive(-x);
        else return reversePositive(x);
    }

    private static int reversePositive(int x) {
        if (x < 10) return x;
        while (x % 10 == 0) x = x/10;

        int result = 0;
        while (x > 0) {
            // number is overflow
            result = result * 10 + x % 10;
//            if (result > Integer.MAX_VALUE/10) return 0;
//            System.out.println("Result " + result);
            x = x/10;
        }

        return result;
    }
}
