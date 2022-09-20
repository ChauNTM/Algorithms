package main.java.cmnguyen.problems.easy;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] seen = new int[26];

        for (int i=0; i < s.length(); i++) {
            seen[s.charAt(i) - 'a']++;
            seen[t.charAt(i) - 'a']--;
        }

        for (int j : seen) {
            if (j != 0) return false;
        }

        return true;
    }
}
