package main.java.cmnguyen.graph.digraph;

import main.java.cmnguyen.graph.weighted.digraph.WeightedDigraph;

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

    public Topological(WeightedDigraph graph) {
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
