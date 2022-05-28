package main.java.cmnguyen.graph.weighted.graph;


import main.java.cmnguyen.graph.connected.component.UnionFind;
import main.java.cmnguyen.graph.connected.component.WeightedUnionFind;
import main.java.cmnguyen.sorting.heapsort.MinPQ;

import java.util.ArrayDeque;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph g) {
        mst = new ArrayDeque<>();
        UnionFind uf = new WeightedUnionFind(g.V());
        MinPQ<Edge> pq = new MinPQ<>(g.edges(), g.E());

        while(!pq.isEmpty() && mst.size() < g.V() - 1) {
            Edge minEdge = pq.delMin();
            int v = minEdge.either();
            int w = minEdge.other(v);
            if (uf.isConnected(v, w)) continue;
            uf.union(v, w);
            mst.add(minEdge);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double sum = 0.0;
        for (Edge e: mst) {
            sum += e.weight();
        }
        return sum;
    }
}
