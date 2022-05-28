package main.java.cmnguyen.problems.easy;

import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * Input: s = "(]"
 * Output: false
 *
 * Input: s = "()[]{}"
 * Output: true
 *
 * Input: s="{[]}"
 * Output: true
 * */
public class ValidParentheses {
    // Note: write code so that people get easier to read through the function
    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character ch: s.toCharArray()) {
            if (stack.isEmpty() && (ch == ')' || ch == ']' || ch == '}')) return false;
            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }
            else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
            else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
