package main.java.cmnguyen.graph;

import main.java.cmnguyen.graph.undirected.*;

public class Main {

    public static void main(String[] args) {
//        Graph graph = GraphReader.readGraph("graph.txt");
//        System.out.println("graph " + graph);
//
//        testDFSPaths(graph);
//        System.out.println();
//        testBFSPaths(graph);
//        System.out.println();
//
//        Graph graph1 = GraphReader.readGraph("graph1.txt");
//        System.out.println("graph " + graph1);
//        testConnectedComponents(graph1);
//
//        Graph noCycleGraph = GraphReader.readGraph("graph_no_cycle.txt");
//        System.out.println("graph " + noCycleGraph);
//        testCycle(noCycleGraph);
//
//        Graph bipartiteGraph = GraphReader.readGraph("bipartite.txt");
//        System.out.println("graph " + bipartiteGraph);
//        testBipartite(bipartiteGraph);

//        testSymbolGraph();
        degreeOfSeparation();

    }

    static void testDFSPaths(Graph graph) {
        int source = 3;
        Paths search = new DepthFirstPaths(graph, source);
        System.out.println("Paths in graph DFS");
        for (int w = 0; w < graph.V(); w++) {
            if (search.hasPathTo(w)) {
                for (int x : search.pathTo(w)) {
                    if (x == source) System.out.println("-" + x);
                    else System.out.print("-" + x);
                }
            }

        }
    }

    static void testBFSPaths(Graph graph) {
        int source = 3;
        Paths search = new BreadthFirstPaths(graph, source);
        System.out.println("Paths in graph BFS");
        for (int w = 0; w < graph.V(); w++) {
            if (search.hasPathTo(w)) {
                for (int x : search.pathTo(w)) {
                    if (x == source) System.out.println("-" + x);
                    else System.out.print("-" + x);
                }
            }
        }
    }

    static void testConnectedComponents(Graph graph) {
        ConnectedComponents cc = new ConnectedComponents(graph);
        System.out.println("components = " + cc.count());
        int p = 3;
        int q = 0;
        System.out.println("Is " + p + " and " + q + " connected? " + cc.isConnected(p, q));
        System.out.println("Is " + 1 + " and " + 3 + " connected? " + cc.isConnected(1, 3));
        System.out.println("Is " + 5 + " and " + 2 + " connected? " + cc.isConnected(5, 2));
        System.out.println("Connected Components: " + cc);
    }

    static void testCycle(Graph graph) {
        Cycle cycle = new Cycle(graph);
        System.out.println("Does graph has cycle: " + cycle.hasCycle());
    }

    static void testBipartite(Graph graph) {
        Bipartite bipartite = new Bipartite(graph);
        System.out.println("Is graph bipartite: " + bipartite.isBipartite());
    }

    static void testSymbolGraph() {
        String fileName = "movie.txt";
        SymbolGraph sg = new SymbolGraph(fileName, "/");

        Graph g = sg.graph();
        String source = "Bambi (1942)";
        for (int w: g.adj(sg.index(source))) {
            System.out.println("Vertices connect to source " + source + " " + sg.name(w));
        }
    }

    static void degreeOfSeparation() {
        String fileName = "movie.txt";
        SymbolGraph sg = new SymbolGraph(fileName, "/");

        Graph graph = sg.graph();
        String source = "Bacon, Kevin";
        if (!sg.contains(source)) System.out.println(source + " doesn't belong to the graph");
        int sourceVertex = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, sourceVertex);
        String target = "Bermingham, Reverend Thomas";
        int targetVertex = sg.index(target);
        if (bfs.hasPathTo(targetVertex)) {
            for(int w: bfs.pathTo(targetVertex)) {
                System.out.println("   " + sg.name(w));
            }
        }
    }

}
