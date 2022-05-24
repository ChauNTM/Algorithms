package main.java.cmnguyen.graph.digraph;

import main.java.cmnguyen.graph.undigraph.GraphReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class DigraphReader {
    public static Digraph readGraph(String fileName) {
        BufferedReader reader = null;
        try {
            InputStream is = GraphReader.class.getClassLoader().getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int V = Integer.parseInt(reader.readLine());
            int E = Integer.parseInt(reader.readLine());
            Digraph graph = new Digraph(V);
            String line;
            while((line = reader.readLine()) != null) {
                String[] edges = line.split(" ");
                graph.addEdge(Integer.parseInt(edges[0]), Integer.parseInt(edges[1]));
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
