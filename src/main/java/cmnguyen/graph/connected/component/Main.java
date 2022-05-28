package main.java.cmnguyen.graph.connected.component;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        int N = 10;
        UnionFind uf = new WeightedUnionFind(N);
        int[] adj = new int[] { 4, 3, 3, 8, 6, 5, 9, 4, 2, 1, 8, 9, 5, 0, 7, 2, 6, 1, 1, 0, 6, 7 };
        for (int i=0; i<adj.length; i=i+2)
        {
            int p = adj[i];
            int q = adj[i+1];
            if (uf.isConnected(p, q)) continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(uf.count + " components");
        System.out.println("components=" + Arrays.toString(uf.id));
    }
}
