package main.java.cmnguyen.searching.segment_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MaximumSegmentTree {
    int[][] max;
    int n;
    private static final int MAX_LENGTH = 100;

    public MaximumSegmentTree(int[] nums) {
        n = nums.length;
        max = new int[MAX_LENGTH][2];
        build(nums, 1, 0, n - 1);
    }

    private int[] combine(int[] a, int[] b) {
        if (a[0] > b[0]) {
            return a;
        } else if (a[0] < b[0]) {
            return b;
        }
        return new int[]{a[0], a[1] + b[1]};
    }

    private void build(int[] nums, int v, int tl, int tr) {
        if (tl == tr) {
            max[v] = new int[]{nums[tl], 1};
            return;
        }

        int tm = (tl + tr) / 2;
        build(nums, 2 * v, tl, tm);
        build(nums, 2 * v + 1, tm + 1, tr);

        max[v] = combine(max[2*v], max[2 * v + 1]);
    }

    public void update(int index, int value) {
        update(1, 0, n -1, index, value);
    }

    private void update(int v, int tl, int tr, int index, int value) {
        if (tl == tr) {
            max[v] = new int[]{value, 1};
            return;
        }

        int tm = (tl + tr) / 2;
        if (index <= tm) {
            update(2 * v, tl, tr, index, value);
        } else {
            update(2 * v + 1, tl, tr, index, value);
        }
        max[v] = combine(max[2 * v], max[2 * v + 1]);
    }

    public int[] getMax(int l, int r) {
        return getMax(1, 0, n - 1, l, r);
    }

    private int[] getMax(int v, int tl, int tr, int l, int r) {
        if (l > r) return new int[]{Integer.MIN_VALUE, 0};
        if (tl == l && tr == r) {
            return max[v];
        }

        int tm = (tl + tr) / 2;
        return combine(getMax(2 * v, tl, tm, l, Math.min(tm, r)),
            getMax(2 * v + 1, tm + 1, tr, Math.max(tm + 1, l), r));

    }

    public int findFirstGreaterThan(int value) {
        return findFirstGreaterThan(1, 0, n - 1, value);
    }

    private Map<Integer, Integer> combine(Map<Integer, Integer> a, Map<Integer, Integer> b) {
        Map<Integer, Integer> merge = new HashMap<>(Map.copyOf(a));
        for (int item : b.keySet()) {
            merge.put(item, b.get(item));
        }
        Function<Integer, Integer> lower_bound = (pos) -> pos < 0 ? ~pos : pos;

        return merge;
    }

    private int findFirstGreaterThan(int v, int tl, int tr, int value) {
        if (max[v][0] <= value) return Integer.MIN_VALUE;
        if (tl == tr) return max[v][0];

        int tm = (tl + tr) / 2;
        if (max[2*v][0] > value) {
            return findFirstGreaterThan(2 * v, tl, tm, value);
        }
        return findFirstGreaterThan(2 * v + 1, tm + 1, tr, value);

    }


}
