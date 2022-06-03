package main.java.cmnguyen.graph.weighted.digraph;

import java.util.Stack;

public class EdgeWeightedCycleFinder {
    private boolean[] onStack;
    private boolean[] marked;
    private DirectedWeighedEdge[] edgeTo;
    private Stack<DirectedWeighedEdge> cycle;
    private double weight;

    public EdgeWeightedCycleFinder(WeightedDigraph graph) {
        onStack = new boolean[graph.V()];
        marked = new boolean[graph.V()];
        edgeTo = new DirectedWeighedEdge[graph.V()];

        for (int v=0; v<graph.V(); v++) {
            if (!marked[v]) dfs(graph, v);
        }

    }

    private void dfs(WeightedDigraph graph, int v) {
        marked[v] = true;
        onStack[v] = true;
        for (DirectedWeighedEdge e: graph.adj(v)) {
            int w = e.to();
            if (hasNegativeCycle()) return;
            if (!marked[w]) {
                edgeTo[w] = e;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                weight = 0.0;
                for (DirectedWeighedEdge edge = e; edge.from() != w; edge = edgeTo[edge.from()]) {
                    cycle.push(edge);
                    weight += edge.weighted();
                }
                cycle.push(e);
                weight += e.weighted();
            }
        }
        onStack[v] = false;
    }

    public boolean hasNegativeCycle() {
        return cycle != null && weight < 0;
    }

    Iterable<DirectedWeighedEdge> negativeCycle() {
        return cycle;
    }

    public double cycleWeight() { return weight; }

}
