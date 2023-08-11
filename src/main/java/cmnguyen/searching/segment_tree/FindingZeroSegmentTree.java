package main.java.cmnguyen.searching.segment_tree;

public class FindingZeroSegmentTree {
    int[] count;
    int n;
    private static final int MAX_LENGTH = 100;

    public FindingZeroSegmentTree(int[] nums) {
        n = nums.length;
        count = new int[MAX_LENGTH];
        build(nums, 1, 0, n - 1);
    }

    private void build(int[] nums, int v, int tl, int tr) {
        if (tl == tr) {
            count[v] = nums[tl] == 0 ? 1 : 0;
            return;
        }

        int tm = (tl + tr) / 2;
        build(nums, 2 * v, tl, tm);
        build(nums, 2 * v + 1, tm + 1, tr);

        count[v] = count[2 * v] + count[2 * v + 1];
    }

    public int findKthZero(int k) {
        return findKthZero(1, 0, n - 1, k);
    }

    private int findKthZero(int v, int tl, int tr, int k) {
        if (count[v] < k) return -1;
        if (tl == tr) return tl;

        int tm = (tl + tr) / 2;
        if (count[2 * v] >= k) {
            return findKthZero(2 * v, tl, tm, k);
        }
        return findKthZero(2 * v + 1, tm + 1, tr, k - count[2 * v]);
    }
}
