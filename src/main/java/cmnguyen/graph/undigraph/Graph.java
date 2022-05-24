package main.java.cmnguyen.graph.undigraph;

import java.util.ArrayList;

public class Graph {
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;

    public Graph(int vertices) {
        V = vertices;
        E = 0;
        adj = new ArrayList[V];
        for (int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public int V() { return V; }

    public int E() { return E; }

    public void addEdge(int v, int w) {
        adj[v].add(0, w);
        adj[w].add(0, v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int degree(int v) {
        if (v >= V) return 0;
        return adj[v].size();
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v=0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }
}
