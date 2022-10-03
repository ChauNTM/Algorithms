package main.java.cmnguyen.problems.medium.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        List<Integer> result = new ArrayList<>();

        for (int j = 0; j < p.length(); j++) {
            sCount[s.charAt(j) - 'a']++;
            pCount[p.charAt(j) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) result.add(0);
        int windowSize = p.length();

        for (int j = p.length(); j < s.length(); j++) {
            sCount[s.charAt(j) - 'a']++;
            sCount[s.charAt(j - windowSize) - 'a']--;

            if (Arrays.equals(sCount, pCount)) result.add(j - windowSize + 1);

        }

        return result;
    }

}
