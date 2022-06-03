package main.java.cmnguyen.graph.weighted.digraph;

public class Main {

    public static void main(String[] args) {
        testBellmanFordSP();
    }

    static void testDijkstraSP() {
        WeightedDigraph g = WeightedDigraphReader.readGraph("tinyEWD.txt");
        System.out.println("Edge weighted graph g \n" + g);

        DijkstraSP sp = new DijkstraSP(g, 0);
        for (int i=0; i<g.V(); i++) {
            System.out.println("Dijkstra shortest path - vertex " + i  + ": " + sp.pathTo(i));
            System.out.println("Dijkstra shortest path - total weight for " + i  + ": " + sp.distTo(i));
        }
    }

    static void testAcyclicSP() {
        WeightedDigraph g = WeightedDigraphReader.readGraph("tinyEWDAG.txt");
        System.out.println("Edge weighted graph g \n" + g);

        AcyclicSP sp = new AcyclicSP(g, 5);
        for (int i=0; i<g.V(); i++) {
            System.out.println("AcyclicSP shortest path - vertex " + i  + ": " + sp.pathTo(i));
            System.out.println("AcyclicSP shortest path - total weight for " + i  + ": " + sp.distTo(i));
        }
    }

    static void testEdgeWeightedCycleFinder() {
        WeightedDigraph g = WeightedDigraphReader.readGraph("tinyEWDnc.txt");
        System.out.println("Edge weighted graph g \n" + g);

        EdgeWeightedCycleFinder finder = new EdgeWeightedCycleFinder(g);
        if (finder.hasNegativeCycle()) {
            for (DirectedWeighedEdge e: finder.negativeCycle()) {
                System.out.print(e + " \t");
            }
            System.out.println("Negative weight " + finder.cycleWeight());
        }
    }

    static void testBellmanFordSP() {
        WeightedDigraph g = WeightedDigraphReader.readGraph("tinyEWDnc.txt");
        System.out.println("Edge weighted graph g \n" + g);

        BellmanFordSP sp = new BellmanFordSP(g, 0);
        for (int i=0; i<g.V(); i++) {
            System.out.println("BellmanFord shortest path - vertex " + i  + ": " + sp.pathTo(i));
            System.out.println("BellmanFord shortest path - total weight for " + i  + ": " + sp.distTo(i));
        }
    }

}
