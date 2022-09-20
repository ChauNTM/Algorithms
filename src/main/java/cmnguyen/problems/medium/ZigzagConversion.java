package main.java.cmnguyen.problems.medium;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int length = s.length();
        char[] zigzag = new char[length];
        
        for (int i = 0; i < length; i++) {
            zigzag[i] = s.charAt(i*(2*numRows - 2) % length);
        }

        return new String(zigzag);
    }
}
