package main.java.cmnguyen.graph.weighted.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    List<Edge>[] adj;
    private final int V;
    private int E;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adj = new List[V];
        for (int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(Edge edge) {
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        List<Edge> edgeList = new ArrayList<>();
        for (int v=0; v<adj.length; v++) {
            for(Edge edge: adj[v]) {
                if (edge.other(v) > v) edgeList.add(edge);
            }
        }
        return edgeList;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (Edge edge : edges()) {
            s += edge.toString();
            s += "\n";
        }
        return s;
    }

}
