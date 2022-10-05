package main.java.cmnguyen.problems.medium;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int[] ids = new int[256];
        int res = 0;
        for (int k =0; k < 256; k++) ids[k] = -1;
        int i = 0;

        for (int j = 0; j < s.length(); j++) {
            if (ids[s.charAt(j)] > -1 && ids[s.charAt(j)] >= i) {
                res = Math.max(res, j - i);
                i = ids[s.charAt(j)] + 1;
            }
            ids[s.charAt(j)] = j;
        }
        res = Math.max(res, s.length() - i);

        return res;
    }
}
