package main.java.cmnguyen.graph.weighted.digraph;

import main.java.cmnguyen.sorting.heapsort.IndexMinPQ;

import java.util.Arrays;

/**
 * Using Dijkstra for finding shorted path in edge-weighted digraph with nonnegative weights.
 * This algorithms can be used for both acyclic graphs and cyclic graphs
 * */
public class DijkstraSP extends AbstractSP {
    private IndexMinPQ<Double> pq;

    public DijkstraSP(WeightedDigraph g, int s) {
        this.s = s;

        edgeTo = new DirectedWeighedEdge[g.V()];
        distTo = new double[g.V()];
        Arrays.fill(distTo, Double.MAX_VALUE);

        pq = new IndexMinPQ<>(g.V());
        pq.insert(s, 0.0);
        distTo[s] = 0.0;

        while (!pq.isEmpty()) relax(g, pq.delMin());
    }

    @Override
    protected void relax(WeightedDigraph g, int v) {
        for(DirectedWeighedEdge e : g.adj(v)) {
            int w = e.to();
            double dist = distTo[v] + e.weighted();
            if (distTo[w] >= dist) {
                distTo[w] = dist;
                edgeTo[w] = e;
                if (pq.contains(w)) pq.change(w, e.weighted());
                else pq.insert(w, e.weighted());
            }
        }
    }
}
