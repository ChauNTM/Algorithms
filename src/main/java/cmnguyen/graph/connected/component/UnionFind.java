package main.java.cmnguyen.graph.connected.component;

public abstract class UnionFind {

    protected int[] id;

    // Number of components
    protected int count;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i] = i;
        }
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);
    public abstract void union(int p, int q);

}
