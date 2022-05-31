package main.java.cmnguyen.graph.weighted.digraph;

import main.java.cmnguyen.graph.digraph.Topological;

public class AcyclicLP extends AbstractSP{

    public AcyclicLP(WeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedWeighedEdge[g.V()];
        this.s = s;

        distTo[s] = 0.0;
        Topological topological = new Topological(g);
        for (int v: topological.order()) {
            relax(g, v);
        }
    }

    @Override
    protected void relax(WeightedDigraph g, int v) {
        for (DirectedWeighedEdge e: g.adj(v)) {
            int w = e.to();
            if (distTo[w] < distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }
}
