package main.java.cmnguyen.problems.hard;

import main.java.cmnguyen.problems.hard.heap.MergeSortedLinkList;
import main.java.cmnguyen.problems.medium.MaxProfitII;
import main.java.cmnguyen.problems.structure.ListNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        maxProfitIII();
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
}
