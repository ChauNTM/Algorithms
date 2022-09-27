package main.java.cmnguyen.problems.medium.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    private static boolean hasNoCycle = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] G = new ArrayList[numCourses];
        for (int i=0; i < numCourses; i++) {
            G[i] = new ArrayList<>();
        }

        boolean[] onStack = new boolean[numCourses];
        int[] marked = new int[numCourses];

        for (int[] pre: prerequisites) {
            if (G[pre[0]] == null)
                G[pre[0]] = new ArrayList<>();
            G[pre[0]].add(pre[1]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (marked[course] != -1) {
                dfs(course, G, onStack, marked);
            }
        }

        return hasNoCycle;
    }

    private static void dfs(int course, List<Integer>[] preCourse, boolean[] onStack, int[] marked) {
        onStack[course] = true;
        marked[course] = -1;

        for(int w: preCourse[course]) {
            if (!hasNoCycle) return;
            else if (marked[w] != -1) {
                dfs(w, preCourse, onStack, marked);
            } else if (onStack[w]) {
                hasNoCycle = false;
            }
        }

        onStack[course] = false;
    }

}
