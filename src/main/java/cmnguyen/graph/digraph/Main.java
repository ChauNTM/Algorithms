package main.java.cmnguyen.graph.digraph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        testKosarajuSCC();
    }

    static void testDirectedDFS() {
        Digraph dg = DigraphReader.readGraph("tinyDG.txt");
        List<Integer> sources = Arrays.asList(1, 2, 6);
        DirectedDFS dfs = new DirectedDFS(dg, sources);
        for (int v=0; v < dg.V(); v++) {
            if (dfs.marked(v)) System.out.print(v + "   ");
        }
    }

    static void testDirectedCycle() {
        Digraph dg = DigraphReader.readGraph("tinyDG.txt");
        DirectedCycle algo = new DirectedCycle(dg);
        System.out.println("Digraph has cycle " + algo.hasCycle());
        if (algo.hasCycle()) {
            Stack<Integer> cycle = algo.cycle();
            int[] edges = new int[cycle.size()];
            int i = 0;
            while (!cycle.isEmpty()) edges[i++] = cycle.pop();
            System.out.println("Cycle of digraph: " + Arrays.toString(edges));
        }
    }

    static void testTopological() {
        Digraph dg = DigraphReader.readGraph("noCycleDG.txt");
        System.out.println("Digraph " + dg);
        Topological topological = new Topological(dg);
        List<Integer> cycle = topological.order();
        System.out.println("Topological " + cycle);
    }

    static void testKosarajuSCC() {
        Digraph dg = DigraphReader.readGraph("kosaraju.txt");
        System.out.println("Digraph: " + dg);
        KosarajuSCC scc = new KosarajuSCC(dg);
        System.out.println(scc.count() + " components");
        System.out.println("ids " + Arrays.toString(scc.id));
    }

}
