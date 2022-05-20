package main.java.cmnguyen.graph.undirected;

public class DFS {
    boolean[] marked;
    int count;

    public DFS(Graph graph, int g) {
        marked = new boolean[graph.V()];
        dfs(graph, g);
    }

    protected void dfs(Graph graph, int v) {
        marked[v] = true;
        count++;
        for (int w: graph.adj(v)) {
            if (!marked[w]) dfs(graph, w);
        }
    }
}
