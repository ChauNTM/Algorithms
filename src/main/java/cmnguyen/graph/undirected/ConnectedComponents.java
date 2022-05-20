package main.java.cmnguyen.graph.undirected;

import java.util.Arrays;

public class ConnectedComponents {
    boolean[] marked;
    // components identifier for v
    int[] id;
    int count;

    public ConnectedComponents(Graph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)) {
            if (!marked[w]) dfs(graph, w);
        }
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        if (v > id.length || w > id.length) throw new IllegalArgumentException("vertex is too large");
        return id[v] == id[w];
    }

    public String toString() {
        return Arrays.toString(id);
    }

}
