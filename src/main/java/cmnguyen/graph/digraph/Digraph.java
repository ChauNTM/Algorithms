package main.java.cmnguyen.graph.digraph;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
    private List<Integer>[] adj;
    private int V;
    private int E;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Digraph reverse() {
        Digraph g = new Digraph(this.V);
        for (int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                g.addEdge(w, v);
            }
        }
        return g;
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v)) {
                s += w + " ";
            }
            s += "\n";
        }
        return s;
    }

}
