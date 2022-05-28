package main.java.cmnguyen.graph.connected.component;

public class WeightedUnionFind extends UnionFind {
    int[] size;

    public WeightedUnionFind(int N) {
        super(N);
        size = new int[N];
        for (int i=0; i<N; i++) {
            size[i] = 1;
        }
    }

    @Override
    int find(int p) {
        while(id[p] != p) p = id[p];
        return p;
    }

    @Override
    void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) return;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
}
