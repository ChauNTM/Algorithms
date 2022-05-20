package main.java.cmnguyen.graph.undirected;

import java.util.Stack;

public class Paths {
    int source;
    boolean[] marked;
    int[] edgeTo;

    public Paths(Graph graph, int s) {
        source = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        Stack<Integer> stack = new Stack<>();
        for (int x = v; x != source; x = edgeTo[x]) {
            stack.push(x);
        }
        stack.push(source);
        return stack;
    }
}
