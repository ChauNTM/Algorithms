package main.java.cmnguyen.graph.weighted.graph;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testPrimMST();
        testKruskalMST();
    }

    static void testLazyPrimMST() {
        EdgeWeightedGraph g = EdgeWeightedGraphReader.readGraph("tinyEWG.txt");
        System.out.println("Edge weighted graph g \n" + g);

        LazyPrimMST mst = new LazyPrimMST(g);
        System.out.println("lazy Prim MST - edges: " + Arrays.toString(mst.mst.toArray()));
        System.out.println("lazy Prim MST - total weight: " + mst.weight());
    }

    static void testPrimMST() {
        EdgeWeightedGraph g = EdgeWeightedGraphReader.readGraph("tinyEWG.txt");
        System.out.println("Edge weighted graph g \n" + g);

        PrimMST prim = new PrimMST(g);
        System.out.println("Prim MST - edges: " + prim.edges());
        System.out.println("Prim MST - total weight: " + prim.weight());
    }

    static void testKruskalMST() {
        EdgeWeightedGraph g = EdgeWeightedGraphReader.readGraph("tinyEWG.txt");
        System.out.println("Edge weighted graph g \n" + g);

        KruskalMST kruskal = new KruskalMST(g);
        System.out.println("Kruskal MST - edges: " + kruskal.edges());
        System.out.println("Kruskal MST - total weight: " + kruskal.weight());
    }
}
