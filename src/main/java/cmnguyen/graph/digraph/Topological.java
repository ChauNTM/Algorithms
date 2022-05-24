package main.java.cmnguyen.graph.digraph;

import java.util.Stack;

public class Topological {
    private Stack<Integer> order;

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

    public Stack<Integer> order() {
        return order;
    }
}
