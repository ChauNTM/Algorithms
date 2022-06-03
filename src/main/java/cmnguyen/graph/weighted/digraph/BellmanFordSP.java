package main.java.cmnguyen.graph.weighted.digraph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BellmanFordSP extends AbstractSP {
    private boolean[] onQueue;
    private Queue<Integer> queue;
    // number of calls to relax
    private int cost;
    private Iterable<DirectedWeighedEdge> cycle;

    public BellmanFordSP(WeightedDigraph graph, int s) {
        onQueue = new boolean[graph.V()];
        queue = new ArrayDeque<>();
        distTo = new double[graph.V()];
        edgeTo = new DirectedWeighedEdge[graph.V()];
        this.s = s;
        for (int v=0; v< graph.V(); v++) {
            distTo[v] = Double.MAX_VALUE;
            onQueue[v] = false;
        }

        queue.add(s);
        onQueue[s] = true;
        distTo[s] = 0;
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.remove();
            onQueue[v] = false;
            relax(graph, v);
        }
    }

    @Override
    protected void relax(WeightedDigraph graph, int v) {
        for (DirectedWeighedEdge e: graph.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weighted()) {
                edgeTo[w] = e;
                distTo[w] = distTo[v] + e.weighted();
                if (!onQueue[w]) {
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
            if (cost++ % graph.V() == 0) findNegativeCycle();
        }
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedWeighedEdge> negativeCycle() {
        return cycle;
    }

    private void findNegativeCycle() {
        int V = edgeTo.length;
        WeightedDigraph graph = new WeightedDigraph(V);
        for (int v = 0; v<V; v++) {
            if (edgeTo[v] != null) graph.addEdge(edgeTo[v]);
        }

        EdgeWeightedCycleFinder finder = new EdgeWeightedCycleFinder(graph);
        cycle = finder.negativeCycle();
    }



}
