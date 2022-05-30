package main.java.cmnguyen.graph.weighted.digraph;

import main.java.cmnguyen.graph.digraph.Topological;

/**
 * Using this algorithms for finding shorted path in acyclic edge-weighted digraph
 * with edges can be either negative or positive
 * */
public class AcyclicSP extends AbstractSP {

    public AcyclicSP(WeightedDigraph g, int s) {
        distTo = new double[g.V()];
        edgeTo = new DirectedWeighedEdge[g.V()];
        for (int i=0; i<g.V(); i++) distTo[i] = Double.MAX_VALUE;
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
            if (distTo[w] > distTo[v] + e.weighted()) {
                distTo[w] = distTo[v] + e.weighted();
                edgeTo[w] = e;
            }
        }
    }
}
