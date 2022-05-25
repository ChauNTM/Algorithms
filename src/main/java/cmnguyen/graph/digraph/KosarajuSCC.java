package main.java.cmnguyen.graph.digraph;

public class KosarajuSCC {
    private boolean[] marked;
    private int count = 0;
    public int[] id;
    private int[] edgeTo;

    public KosarajuSCC(Digraph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        edgeTo = new int[graph.V()];
        DepthFirstOrder dfo = new DepthFirstOrder(graph.reverse());
        for (int s: dfo.revertedPost()) {
            if (!marked[s]) {
                dfs(graph, s);
                count++;
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w: graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }
}
