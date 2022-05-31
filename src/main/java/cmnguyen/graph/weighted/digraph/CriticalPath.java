package main.java.cmnguyen.graph.weighted.digraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CriticalPath {
    public static class Pair<K, V> {
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        K key;
        V value;
    }

    public static void main(String[] args) {
        Pair<WeightedDigraph, Integer> g = readJobs("jobsPC.txt");
        int N = g.value;
        AcyclicLP lp = new AcyclicLP(g.key, 2*N);
        System.out.println("Start times: ");
        for (int v = 0; v < N; v++) {
            System.out.printf("%4d: %5.1f\n", v, lp.distTo(v));
        }
        System.out.printf("Finish time: %5.1f\n", lp.distTo(2*N+1));
    }

    public static Pair<WeightedDigraph, Integer> readJobs(String fileName) {
        BufferedReader reader = null;
        try {
            InputStream is = WeightedDigraph.class.getClassLoader().getResourceAsStream(fileName);
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            int N = Integer.parseInt(reader.readLine());
            WeightedDigraph graph = new WeightedDigraph(2*N + 2);
            // add 2 more vertices s, t to the graph
            int s = 2*N;
            int t = 2*N + 1;
            String line;
            int jobStart = 0;
            while((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                // with every vertex, add 3 edges to connect vertices with s, t and itself
                // job start has index i, job end has index N+i
                int jobEnd = N+jobStart;
                graph.addEdge(new DirectedWeighedEdge(s, jobStart, 0.0));
                graph.addEdge(new DirectedWeighedEdge(jobEnd, t, 0.0));
                double duration = Double.parseDouble(lines[0]);
                graph.addEdge(new DirectedWeighedEdge(jobStart, jobEnd, duration));
                for (int j=1; j<lines.length; j++) {
                    int successor = Integer.parseInt(lines[j]);
                    graph.addEdge(new DirectedWeighedEdge(jobEnd, successor, 0.0));
                }
                jobStart++;
            }
            return new Pair<>(graph, N);

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
