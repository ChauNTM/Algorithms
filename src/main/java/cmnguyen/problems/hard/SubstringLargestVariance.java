package main.java.cmnguyen.problems.hard;

public class SubstringLargestVariance {
    public static int largestVariance(String s) {
        int[] frequency = new int[26];
        for (int i=0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'a']++;
        }

        int result = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                if (a == b || frequency[a] == 0 || frequency[b] == 0) continue;

                int variance = 0;
                boolean isStartWithB = false;
                boolean hasB = false;
                for (int k=0; k < s.length(); k++) {
//                    System.out.println("debug variance=" + variance);
                    int ch = s.charAt(k) - 'a';
                    if (ch == a) variance++;
                    else if (ch == b) {
                        hasB = true;
                        if (isStartWithB && variance >= 0) {
                            isStartWithB = false;
                        } else if (--variance < 0){
                            isStartWithB = true;
                            variance = -1;
                        }
                    }

                    if (hasB) result = Math.max(result, variance);
                }
            }
        }

        return result;
    }
}
