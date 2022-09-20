package main.java.cmnguyen.problems.hard;

import java.util.*;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
    
    private static List<String> dfs(String s, List<String> wordDist, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(s)) return map.get(s);

        LinkedList<String> result = new LinkedList<String>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordDist) {
            if (s.startsWith(word)) {
                List<String> subRes = dfs(s.substring(word.length()), wordDist, map);
                for (String str : subRes) {
                    result.add(word + (str.isEmpty()? "" : " ") + str);
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
