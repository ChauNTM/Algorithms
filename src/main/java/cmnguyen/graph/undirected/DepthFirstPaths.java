package main.java.cmnguyen.graph.undirected;

public class DepthFirstPaths extends Paths {
    public DepthFirstPaths(Graph graph, int v) {
        super(graph, v);
        dfs(graph, source);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w: graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }
}
