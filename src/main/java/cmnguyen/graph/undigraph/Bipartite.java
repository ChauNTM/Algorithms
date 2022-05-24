package main.java.cmnguyen.graph.undigraph;

public class Bipartite {
    boolean[] marked;
    boolean[] color;
    boolean isTwoColorable = true;

    public Bipartite(Graph graph) {
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        for(int s = 0; s < graph.V(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for(int w: graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]) isTwoColorable = false;
        }
    }

    public boolean isBipartite() {
        return isTwoColorable;
    }
}
