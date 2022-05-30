package main.java.cmnguyen.graph.weighted.digraph;

public class DirectedWeighedEdge {
    private double weight;
    private int v;
    private int w;

    public DirectedWeighedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weighted() {
        return weight;
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
