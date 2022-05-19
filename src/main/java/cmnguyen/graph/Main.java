package main.java.cmnguyen.graph;

public class Main {

    public static void main(String[] args) {
        testGraph();
    }

    static void testGraph() {
        Graph graph = GraphReader.readGraph("graph.txt");
        System.out.println("graph " + graph);
    }

}
