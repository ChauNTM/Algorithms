package main.java.cmnguyen.graph.weighted.graph;

import main.java.cmnguyen.sorting.heapsort.IndexMinPQ;

import java.util.*;

public class PrimMST {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph g) {
        marked = new boolean[g.V()];
        edgeTo = new Edge[g.V()];
        distTo = new double[g.V()];
        pq = new IndexMinPQ<>(g.V());

        for (int i=0; i<g.V(); i++)
            distTo[i] = Double.MAX_VALUE;

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while(!pq.isEmpty()) visit(g, pq.delMin());
    }

    private void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e: g.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;
            if (e.weight() < distTo[w]) {
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.change(w, e.weight());
                else pq.insert(w, e.weight());
            }
        }
    }

    public Iterable<Edge> edges() {
        Queue<Edge> edges = new ArrayDeque<>();
        for (Edge e: edgeTo) {
            if (e != null) edges.add(e);
        }
        return edges;
    }

    public double weight() {
        double sum = 0.0;
        for (double weight: distTo) {
            sum += weight;
        }
        return sum;
    }
}
