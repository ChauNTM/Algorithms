package main.java.cmnguyen.problems.medium.stack;


public class RemoveAdjacentDuplicate {
    public static String removeDuplicates(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int[] count = new int[s.length()];

        for (int i =0; i < s.length(); i++) {
            builder.append(s.charAt(i));
            int last = builder.length() - 1;
            count[last] = 1 + (last > 0 && builder.charAt(last) == builder.charAt(last-1) ? count[last-1] : 0);
            if (count[last] >= k) builder.delete(builder.length() - k, builder.length());
        }

        return builder.toString();
    }
}
