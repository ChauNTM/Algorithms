package main.java.cmnguyen.graph.digraph;

import java.util.List;

public class Topological {
    private List<Integer> order;

    public Topological(Digraph graph) {
        DirectedCycle directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfo = new DepthFirstOrder(graph);
            order = dfo.revertedPost();
        }
    }

    public boolean isDAG() {
        return order == null;
    }

    public List<Integer> order() {
        return order;
    }
}
