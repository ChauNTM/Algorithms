package main.java.cmnguyen.searching.segment_tree;

import java.util.Arrays;

public class SumSegmentTree {
    int[] sum;
    int n;
    private int MAX_LENGTH = 100;

    public SumSegmentTree(int[] nums) {
        n = nums.length;
        sum = new int[MAX_LENGTH];
        build(nums, 1, 0, n - 1);
    }

    private void build(int[] nums, int v, int tl, int tr) {
        if (tl == tr) {
            sum[v] = nums[tl];
            return;
        }
        int mid = (tl + tr) / 2;
        build(nums, 2 * v, tl, mid);
        build(nums, 2 * v + 1, mid + 1, tr);

        sum[v] = sum[2 * v] + sum[2 * v + 1];
    }

    public void update(int index, int value) {
        update(1, 0, n - 1, index, value);
    }

    private void update(int v, int tl, int tr, int index, int value) {
        if (tl == tr) {
            sum[v] = value;
            return;
        }

        int mid = (tl + tr) / 2;
        if (index <= mid) {
            update(2 * v, tl, mid, index, value);
        } else {
            update(2 * v + 1, mid + 1, tr, index, value);
        }
        sum[v] = sum[2 * v] + sum[2 * v + 1];
    }

    public int sumRange(int l, int r) {
        return sumRange(1, 0, n - 1, l, r);
    }

    private int sumRange(int v, int tl, int tr, int l, int r) {
        if (l > r) return 0;
        if (tl == l && tr == r) {
            return sum[v];
        }

        int tm = (tl + tr) / 2;
        return sumRange(2 * v, tl, tm, l, Math.min(tm, r)) +
            sumRange(2 * v + 1, tm + 1, tr, Math.max(tm + 1,  l), r);
    }

    public String toString() {
        return Arrays.toString(sum);
    }
}
