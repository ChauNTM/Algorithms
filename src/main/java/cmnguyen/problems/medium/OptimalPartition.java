package main.java.cmnguyen.problems.medium;

public class OptimalPartition {

    public static int partitionString(String s) {
        int[] seen = new int[256];

        for (int i = 0; i < 256; i++) seen[i] = -1;
        int count = 0;
        int startIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            int curPos = seen[s.charAt(i)];
            if (curPos != -1 && curPos >= startIndex) {
                count++;
                startIndex = i;
            }
            seen[s.charAt(i)] = i;
        }

        return ++count;
    }
}
