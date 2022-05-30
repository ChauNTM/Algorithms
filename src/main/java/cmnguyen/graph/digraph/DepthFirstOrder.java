package main.java.cmnguyen.graph.digraph;

import main.java.cmnguyen.graph.weighted.digraph.DirectedWeighedEdge;
import main.java.cmnguyen.graph.weighted.digraph.WeightedDigraph;

import java.util.*;

public class DepthFirstOrder {
    private Queue<Integer> preOrdered;
    private Queue<Integer> postOrdered;
    private Stack<Integer> revertPostOrdered;
    boolean[] marked;

    public DepthFirstOrder(Digraph graph) {
        marked = new boolean[graph.V()];
        preOrdered = new LinkedList<>();
        postOrdered = new LinkedList<>();
        revertPostOrdered = new Stack<>();
        for (int s=0; s<graph.V(); s++) {
            if (!marked[s]) dfs(graph, s);
        }
    }

    public DepthFirstOrder(WeightedDigraph graph) {
        marked = new boolean[graph.V()];
        preOrdered = new LinkedList<>();
        postOrdered = new LinkedList<>();
        revertPostOrdered = new Stack<>();
        for (int s=0; s<graph.V(); s++) {
            if (!marked[s]) dfs(graph, s);
        }
    }

    private void dfs(Digraph graph, int v) {
        preOrdered.add(v);
        marked[v] = true;
        for (int w: graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        postOrdered.add(v);
        revertPostOrdered.push(v);
    }

    private void dfs(WeightedDigraph graph, int v) {
        preOrdered.add(v);
        marked[v] = true;
        for (DirectedWeighedEdge e: graph.adj(v)) {
            int w = e.to();
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        postOrdered.add(v);
        revertPostOrdered.push(v);
    }

    public Iterable<Integer> pre() {
        return preOrdered;
    }

    public Iterable<Integer> post() {
        return postOrdered;
    }

    public List<Integer> revertedPost() {
        List<Integer> list = new ArrayList<>(revertPostOrdered);
        Collections.reverse(list);
        return list;
    }

}
