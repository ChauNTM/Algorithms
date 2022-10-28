package main.java.cmnguyen.problems.easy.b_tree;

import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBST {

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> counter = new HashMap<>();
        int max = findMode(root, counter);

        List<Integer> res = new ArrayList<>();
        for (int key: counter.keySet()) {
            if (counter.get(key) == max) res.add(key);
        }

        return res.stream().mapToInt(i->i).toArray();
    }

    public int findMode(TreeNode root, Map<Integer, Integer> counter) {
        if (root == null) return 0;

        int count = counter.getOrDefault(root.val, 0) + 1;
        counter.put(root.val, count);

        return Math.max(count, Math.max(findMode(root.left, counter), findMode(root.right, counter)));
    }

}
