package main.java.cmnguyen.problems.medium.union_find;

public class CountUnreachablePairs {

    public static long countPairs(int n, int[][] edges) {
        int[] id = new int[n];
        int[] size = new int[n];
        for (int i=0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
        int count = n;

        for (int[] edge : edges) {
            count = union(edge[0], edge[1], id, size, count);
        }

        long result = 0;
        for (int sz: size) {
            if (sz != 0) {
                result += (long) sz * (n -= sz);
            }
        }

        return result;
    }

    private static int find(int p, int[] id) {
        while(p != id[p]) p = id[p];
        return p;
    }

    private static int union(int p, int q, int[] id, int[] size, int count) {
        int pRoot = find(p, id);
        int qRoot = find(q, id);

        if (pRoot == qRoot) return count;

        if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
            size[pRoot] = 0;
        } else {
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
            size[qRoot] = 0;
        }
        --count;
        return count;
    }

}
