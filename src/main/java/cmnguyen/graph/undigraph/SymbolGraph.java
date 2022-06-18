package main.java.cmnguyen.graph.undigraph;

import main.java.cmnguyen.searching.symbol_table.SequentialSearchST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class SymbolGraph {
    Graph g;
    SequentialSearchST<String, Integer> st;
    String[] keys;

    public SymbolGraph(String fileName, String sp) {
        st = new SequentialSearchST<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName));

            String line;
            while((line = reader.readLine()) != null) {
                String[] edges = line.split(sp);
                for (String edge : edges) {
                    if (!st.contains(edge)) st.put(edge, st.size());
                }
            }

            keys = new String[st.size()];
            for (String key: st.keys()) {
                keys[st.get(key)] = key;
            }

        } catch (Exception ex) {
            System.out.println("Exception when read from reader" + ex);
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (Exception ex) {
                System.out.println("Exception when close reader");
            }
        }

        g = new Graph(st.size());
        try {
            reader = new BufferedReader(new FileReader("src/main/resources/" + fileName));
            String line;
            while((line = reader.readLine()) != null) {
                String[] vertices = line.split(sp);
                int p = st.get(vertices[0]);
                for (int i = 1; i < vertices.length; i++) {
                    g.addEdge(p, st.get(vertices[i]));
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception when read from reader" + ex);
        } finally {
            try {
                reader.close();
            } catch (Exception ex) {
                System.out.println("Exception when close reader");
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph graph() {
        return g;
    }
}
