package main.java.cmnguyen.graph.weighted.graph;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LazyPrimMST {
    boolean[] marked;
    Queue<Edge> mst;
    PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph g) {
        marked = new boolean[g.V()];
        mst = new ArrayDeque<>();
        pq = new PriorityQueue<>(Edge::compareTo);
        visit(g, 0);
        while (!pq.isEmpty()) {
            Edge edge = pq.remove();
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w]) continue;
            mst.add(edge);
            if (!marked[v]) visit(g, v);
            if (!marked[w]) visit(g, w);
        }
    }

    void visit(EdgeWeightedGraph g, int v) {
        marked[v] = true;
        for (Edge e: g.adj(v)) {
            if (!marked[e.other(v)]) pq.add(e);
        }
    }

    public Iterable<Edge> mst() {
        return mst;
    }

    public double weight() {
        double totalWeight = 0.0;
        for (Edge e: mst) {
            totalWeight += e.weight();
        }
        return totalWeight;
    }
}
