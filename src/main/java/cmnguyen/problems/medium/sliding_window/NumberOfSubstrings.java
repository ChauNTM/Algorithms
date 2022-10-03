package main.java.cmnguyen.problems.medium.sliding_window;

public class NumberOfSubstrings {

    public static int numberOfSubstrings(String s) {
        int i = 0;
        int[] count = new int[128];
        int n = s.length();
        int res = 0;

        for (int j=0; j < s.length(); j++) {
            count[s.charAt(j)]++;

            while (count['a'] > 0 && count['b'] > 0 && count['c'] > 0) {
                res += n - j;
                count[s.charAt(i++)]--;
            }
        }

        return res;
    }
}
