package main.java.cmnguyen.problems.medium.stack;

import java.util.Stack;

public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        for (int i=0; i < tokens.length; i++) {
            String token = tokens[i];
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                numbers.push(Integer.parseInt(token));
            } else {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                switch (token) {
                    case "+":
                        num2 += num1;
                        break;
                    case "-":
                        num2 -= num1;
                        break;
                    case "*":
                        num2 *= num1;
                        break;
                    case "/":
                        num2 /= num1;
                        break;
                }
                numbers.push(num2);
            }
        }
        return numbers.pop();
    }
}
