package main.java.cmnguyen.problems.hard;

import main.java.cmnguyen.problems.hard.bfs.JumpGameIV;
import main.java.cmnguyen.problems.hard.diikstra.MinimumCost;
import main.java.cmnguyen.problems.hard.heap.MergeSortedLinkList;
import main.java.cmnguyen.problems.structure.ListNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        jumpGameIV();
    }

    static private void courseScheduleV3() {
//        int[][] courses = new int[][]{{100,200},{200,1300},{1000,1250},{2000,3200}};
        int[][] courses = new int[][]{{1,2}};
        System.out.println("maximum number of courses " + CourseScheduleV3.scheduleCourse(courses));
    }

    static private void mergeSortedLinkList() {
        int[] arr1 = new int[] {1,4,5};
        int[] arr2 = new int[] {1, 3, 4};
        int[] arr3 = new int[] {2, 6};

        ListNode l1 = fromArray(arr1);
        ListNode l2 = fromArray(arr2);
        ListNode l3 = fromArray(arr3);

        System.out.println("merged result " + MergeSortedLinkList.mergeKLists(new ListNode[]{l1, l2, l3}));
    }

    static private ListNode fromArray(int[] arr) {
        ListNode head = null;
        ListNode tail = null;
        for (int j : arr) {
            if (head == null) {
                head = new ListNode(j);
                tail = head;
            } else {
                tail.next = new ListNode(j);
                tail = tail.next;
            }
        }
        return head;
    }

    static private void largestVarianceSubstring(String s) {
        System.out.println("Largest variance substring of " + s + " is " + SubstringLargestVariance.largestVariance(s));
    }

    static private void wordBreakII() {
        String s = "pineapplepineapplepenpine";
        List<String> dictionary = List.of("apple","pen","applepen","pine","pineapple");
        System.out.println(WordBreakII.wordBreak(s, dictionary));
    }

    private static void maxProfitIII() {
        int[] prices = new int[]{1,2,4,2,5,7,2,4,9,0};
        System.out.println("max profit: " + MaxProfitIII.maxProfit(prices));
    }

    private static void subArraysWithKDistinct() {
        int[] nums = new int[]{1,2,1,2,3};
        int k = 2;
        System.out.println("Sub arrays with k distinct number: " + SubArraysWithKDistinct.subarraysWithKDistinct(nums, k));
    }

    private static void jumpGameIV() {
        int[] nums = new int[]{100,-23,-23,404,100,23,23,23,3,404};
        System.out.println("Can jump " + JumpGameIV.minJumps(nums));
    }

    private static void minCost() {
//        int[][] grid = new int[][]{{2,2,2},{2,2,2}};
        int[][] grid = new int[][]{{1,2},{4,3}};
//        int[][] grid = new int[][]{{1,1,3},{3,2,2},{1,1,4}};
//        int[][] grid = new int[][]{{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
        System.out.println("Minimum cost " + MinimumCost.minCost(grid));
    }
}
