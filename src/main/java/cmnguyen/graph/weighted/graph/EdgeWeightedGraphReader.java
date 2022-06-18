package main.java.cmnguyen.graph.weighted.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EdgeWeightedGraphReader {

    public static EdgeWeightedGraph readGraph(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName));

            int V = Integer.parseInt(reader.readLine());
            int E = Integer.parseInt(reader.readLine());
            EdgeWeightedGraph graph = new EdgeWeightedGraph(V);
            String line;
            while((line = reader.readLine()) != null) {
                String[] edges = line.split(" ");
                graph.addEdge(new Edge(
                        Integer.parseInt(edges[0]),
                        Integer.parseInt(edges[1]),
                        Double.parseDouble(edges[2])
                        )
                );
            }
            return graph;

        } catch (Exception ex) {
            System.out.println("Exception while reading file " + ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                // handle an exception, or often we just ignore it
            }
        }

        return null;
    }

}
