package main.java.cmnguyen.graph.weighted.digraph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public abstract class AbstractSP {
    protected double[] distTo;
    protected DirectedWeighedEdge[] edgeTo;
    protected int s;

    public List<DirectedWeighedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedWeighedEdge> path = new Stack<>();
        while (edgeTo[v] != null) {
            path.add(edgeTo[v]);
            v = edgeTo[v].from();
        }
        return path;
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Integer.MAX_VALUE;
    }

    abstract protected void relax(WeightedDigraph g, int v);
}
