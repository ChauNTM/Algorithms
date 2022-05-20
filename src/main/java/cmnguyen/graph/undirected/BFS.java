package main.java.cmnguyen.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    boolean[] marked;
    int[] edgeTo;

    public BFS(Graph graph, int v) {
        bfs(graph, v);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : graph.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.add(w);
                }
            }
        }
    }
}
