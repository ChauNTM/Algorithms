package main.java.cmnguyen.problems.medium.graph;

import java.util.*;

public class CourseScheduleII {
    private static boolean acyclic = false;

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[numCourses];
        for (int i=0; i < numCourses; i++) G[i] = new ArrayList<>();

        for (int[] pre: prerequisites) G[pre[1]].add(pre[0]);

        Deque<Integer> reversePost = new ArrayDeque<>();
        boolean[] marked = new boolean[numCourses];
        boolean[] onStack = new boolean[numCourses];
        for (int i=0; i < numCourses; i++) {
            if (!marked[i]) dfs(G, i, reversePost, marked, onStack);
            if (acyclic) return new int[]{};
        }

        int[] orderArray = new int[numCourses];
        for (int i = 0; !reversePost.isEmpty(); i++) orderArray[i] = reversePost.pop();
        return orderArray;

    }

    private static void dfs(List<Integer>[] G, int course, Deque<Integer> reversePost, boolean[] marked, boolean[] onStack) {
        marked[course] = true;
        onStack[course] = true;

        for (int w: G[course]) {
            if (acyclic) return;
            if (!marked[w]) dfs(G, w, reversePost, marked, onStack);
            else if (onStack[w]) acyclic = true;
        }

        reversePost.push(course);
        onStack[course] = false;
    }

}
