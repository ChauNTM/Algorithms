package main.java.cmnguyen.graph.digraph;

import java.util.Stack;

public class DirectedCycle {
    boolean[] marked;
    boolean[] onStack;
    int[] edgeTo;
    Stack<Integer> cycle;
    public DirectedCycle(Digraph graph) {
        marked = new boolean[graph.V()];
        onStack = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) dfs(graph, s);
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (int w: graph.adj(v)) {
            if (hasCycle()) return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Stack<Integer> cycle() {
        return cycle;
    }
}
