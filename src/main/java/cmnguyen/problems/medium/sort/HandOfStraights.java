package main.java.cmnguyen.problems.medium.sort;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class HandOfStraights {

//    public boolean isNStraightHand(int[] hand, int groupSize) {
//        Map<Integer, Integer> treeMap = new TreeMap<>();
//        for (int i=0; i < hand.length; i++)
//            treeMap.put(hand[i], treeMap.getOrDefault(hand[i], 0) + 1);
//
//        for (int key : treeMap.keySet()) {
//            if (treeMap.get(key) > 0) {
//                for (int w = groupSize - 1; w >= 0; w--) {
//                    if (treeMap.getOrDefault(key + w, 0) < treeMap.get(key)) return false;
//                    treeMap.put(key + w, treeMap.get(key + w) - treeMap.get(key));
//                }
//            }
//        }
//
//        return true;
//    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        for (int i=0; i < hand.length; i++)
            treeMap.put(hand[i], treeMap.getOrDefault(hand[i], 0) + 1);

        int totalOpenGroup = 0;
        int preCards = -1;
        Queue<Integer> openedGroup = new ArrayDeque<>();
        for (int key : treeMap.keySet()) {
            /**
             * There are 2 invalid cases:
             * 1. If we have any open groups, then the current key must be consecutive with the previous cards
             * 2. The total opened group must be less than or equal the frequency of current key
             * */
            if (totalOpenGroup > 0 && key > 1 + preCards || totalOpenGroup > treeMap.get(key)) return false;

            // put new created open group into the queue
            openedGroup.add(treeMap.get(key) - totalOpenGroup);
            // update previous card
            preCards = key;
            // calculate the total open group
            totalOpenGroup = treeMap.get(key);
            // if we have enough keys in open group, then we close the first one
            if (openedGroup.size() == groupSize) totalOpenGroup -= openedGroup.poll();
        }

        return totalOpenGroup == 0;
    }
}
