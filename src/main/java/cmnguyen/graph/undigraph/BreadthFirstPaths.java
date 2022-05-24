package main.java.cmnguyen.graph.undigraph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPaths extends Paths {

    public BreadthFirstPaths(Graph graph, int s) {
        super(graph, s);
        bfs(graph, s);
    }

    private void bfs(Graph graph, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w: graph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }
}
