package main.java.cmnguyen.problems.medium;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty() || s.length() == 1) return s.length();
        int[] characters = new int[256];
        for (int i = 0; i < 256; i++) characters[i] = -1;
        int startIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            int curPos = characters[s.charAt(i)];
            if (curPos != -1 && curPos >= startIndex) {
                maxLength = Math.max(maxLength, i - startIndex);
                startIndex = curPos + 1;
            }
            characters[s.charAt(i)] = i;
        }
        maxLength = Math.max(maxLength, s.length() - startIndex);

        return maxLength;
    }
}
