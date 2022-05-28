package main.java.cmnguyen.graph.weighted.graph;

import main.java.cmnguyen.graph.undigraph.GraphReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class EdgeWeightedGraphReader {

    public static EdgeWeightedGraph readGraph(String fileName) {
        BufferedReader reader = null;
        try {
            InputStream is = GraphReader.class.getClassLoader().getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
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
