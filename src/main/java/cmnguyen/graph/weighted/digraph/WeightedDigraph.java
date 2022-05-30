package main.java.cmnguyen.graph.weighted.digraph;

import main.java.cmnguyen.graph.weighted.graph.Edge;

import java.util.ArrayList;
import java.util.List;

public class WeightedDigraph {
    private List<DirectedWeighedEdge>[] adj;
    private int V;
    private int E;

    public WeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(DirectedWeighedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public List<DirectedWeighedEdge> adj(int v) {
        return adj[v];
    }

    public List<DirectedWeighedEdge> edges() {
        List<DirectedWeighedEdge> edges = new ArrayList<>();
        for(int i=0; i<adj.length; i++) {
            edges.addAll(adj[i]);
        }
        return edges;
    }

    public int V() {
        return V;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (DirectedWeighedEdge edge : edges()) {
            s += edge.toString();
            s += "\n";
        }
        return s;
    }

}
