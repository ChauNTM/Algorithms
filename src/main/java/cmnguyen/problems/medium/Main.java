package main.java.cmnguyen.problems.medium;

import main.java.cmnguyen.problems.hard.ShortestSubArray;
import main.java.cmnguyen.problems.hard.SlidingWindowMaximum;
import main.java.cmnguyen.problems.medium.b_tree.BinaryTreeZigzag;
import main.java.cmnguyen.problems.medium.b_tree.LowestCommonAncestorBT;
import main.java.cmnguyen.problems.medium.b_tree.StepByStepDirectionsBT;
import main.java.cmnguyen.problems.medium.b_tree.TrimBST;
import main.java.cmnguyen.problems.medium.backtrack.*;
import main.java.cmnguyen.problems.medium.bfs.ColoringBorder;
import main.java.cmnguyen.problems.medium.bfs.RottingOranges;
import main.java.cmnguyen.problems.medium.bfs.WordSearch;
import main.java.cmnguyen.problems.medium.binary_search.FindMinInRotatedSortedArrayII;
import main.java.cmnguyen.problems.medium.binary_search.SearchInRotatedSortedArray;
import main.java.cmnguyen.problems.medium.binary_search.SearchInRotatedSortedArrayII;
import main.java.cmnguyen.problems.medium.dfs.MaxAreaOfIsland;
import main.java.cmnguyen.problems.medium.dfs.NumberOfIslands;
import main.java.cmnguyen.problems.medium.dfs.ZeroOneMatrix;
import main.java.cmnguyen.problems.medium.dijkstra.PathWithMinimumEffort;
import main.java.cmnguyen.problems.medium.dijkstra.ShortestPathWithObstacleElimination;
import main.java.cmnguyen.problems.medium.graph.CourseScheduleII;
import main.java.cmnguyen.problems.medium.heap.TopKFrequentWords;
import main.java.cmnguyen.problems.medium.jumpgame.JumpGameII;
import main.java.cmnguyen.problems.medium.kadane.MaximumSubArray;
import main.java.cmnguyen.problems.medium.merge_intervals.InsertInterval;
import main.java.cmnguyen.problems.medium.merge_intervals.IntervalIntersection;
import main.java.cmnguyen.problems.medium.merge_intervals.MergeIntervals;
import main.java.cmnguyen.problems.medium.robot.MinimumCostHomeComingRobot;
import main.java.cmnguyen.problems.medium.sliding_window.*;
import main.java.cmnguyen.problems.medium.sort.k_select.KCloset;
import main.java.cmnguyen.problems.medium.stack.EvaluateRPN;
import main.java.cmnguyen.problems.medium.stack.RemoveAdjacentDuplicate;
import main.java.cmnguyen.problems.medium.tries.LongestWordInDictionary;
import main.java.cmnguyen.problems.medium.tries.MapSum;
import main.java.cmnguyen.problems.medium.tries.ReplaceWords;
import main.java.cmnguyen.problems.medium.two_pointers.*;
import main.java.cmnguyen.problems.medium.union_find.CountUnreachablePairs;
import main.java.cmnguyen.problems.structure.ListNode;
import main.java.cmnguyen.problems.structure.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        combinationSum();
    }

    static private void longestPalindromic() {
        String s = "ac";
        System.out.println("longest palindromic of " + s + " is " + LongestPalindromic.longestPalindrome(s));
    }

    static private void containsMostWater() {
        int[] height = {2,3,4,5,18,17,6};
//        int[] height = {1, 2, 4, 3};
        System.out.println("most area: " + ContainerMostWater.maxArea(height));
    }

    static private void removeDuplicatesV2() {
        int[] nums = new int[] {1,1,1,2,2,3};
        System.out.println("Number of elements: " + RemoveDuplicatesII.removeDuplicates(nums));
        System.out.println("Elements: " + Arrays.toString(nums));
    }

    static private void ThreeSum() {
        int[] nums = new int[]{-1,0,1,2,-1,-4,-2,-3,3,0,4};
        List<List<Integer>> result = ThreeSum.threeSumHashMap(nums);
        System.out.println("Result: " + result);

        nums = new int[]{0,0,0,0};
        System.out.println("Result: " + ThreeSum.threeSumHashMap(nums));

        nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println("Result: " + ThreeSum.threeSumHashMap(nums));

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(-1);
        list1.add(1);

        System.out.println("hashcode: " + List.of(-1, 1, 0).hashCode() + " hashcode2 = " + list1.hashCode());
    }

    static private void test4Sum() {
        int[] nums = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> result = FourSum.fourSum(nums, 0);
        System.out.println("Result: " + result);

        nums = new int[]{2,2,2,2,2};
        System.out.println("Result: " + FourSum.fourSum(nums, 8));

    }

    static private void removeNthNode() {
        int[] arr1 = new int[] {1,2,3,4,5};
        int[] arr2 = new int[] {1};
        int[] arr3 = new int[] {1, 2};

        ListNode l1 = fromArray(arr1);
        ListNode l2 = fromArray(arr2);
        ListNode l3 = fromArray(arr3);
        System.out.println("list 1 " + RemoveNthNode.removeNthFromEnd2Pointers(l1, 2));
        System.out.println("list 2 " + RemoveNthNode.removeNthFromEnd2Pointers(l2, 1));
        System.out.println("list 3 " + RemoveNthNode.removeNthFromEnd2Pointers(l3, 2));
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

    static private void reverseInteger() {
        int number = -123;
        System.out.println("reverse integer: " + ReverseInteger.reverse(number));

        number = 1534236469;
        System.out.println("reverse integer: " + ReverseInteger.reverse(number));

        number = -2147483648;
        System.out.println("reverse integer: " + ReverseInteger.reverse(number));
    }

    private static void addTwoNumbers() {
        int[] arr1 = new int[] {9,9,9,9,9,9,9};
        int[] arr2 = new int[] {9,9,9,9};

        ListNode l1 = fromArray(arr1);
        ListNode l2 = fromArray(arr2);
        System.out.println("list 1 " + l1);
        System.out.println("list 2 " + l2);
        System.out.println("sum " + AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    private static void jumpGame() {
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println("Can jump " + JumpGameII.jump(nums));
    }

    private static void mergeIntervals() {
        int[][] arrays = new int[][]{{1,4},{2,3}};
        int[][] result = MergeIntervals.merge(arrays);
        for (int i=0; i<result.length; i++) {
            System.out.println("Merged arrays: " + Arrays.toString(result[i]));
        }
    }

    private static void permutations() {
        int[] nums = new int[] {2,2,1,1};
        List<List<Integer>> result = PermutationsII.permuteUnique(nums);
        System.out.println("size=" + result.size());
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void maxSubArray() {
        int[] nums = new int[] {5,4,-1,7,8};
        System.out.println("maxSubArray: " + MaximumSubArray.maxSubArray(nums));
    }

    private static void subsets() {
        int[] nums = new int[] {1, 2, 3};
        List<List<Integer>> result = Subsets.subsets(nums);
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void numberOfIsland() {
        char[][] grid = new char[][] {{'1','1','0','0','0'},
                {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        char[][] grid = new char[][]
//                {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        System.out.println("Number of Islands " + NumberOfIslands.numIslands(grid));
    }

    private static void maxAreaOfIsland() {
        int[][] grid = new int[][] {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
//        int[][] grid = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println("Number of Islands " + MaxAreaOfIsland.maxAreaOfIsland(grid));
    }

    private static void countUnreachablePairs() {
        int n = 11;
        int[][] edges = new int[][]
        {{5,0},{1,0},{10,7},{9,8},{7,2},{1,3},{0,2},{8,5},{4,6},{4,2}};
//        int[][] edges = new int[][]{{0,2},{0,5},{2,4},{1,6},{5,4}};
        System.out.println("Number of pairs of different nodes that are unreachable from each other: " + CountUnreachablePairs.countPairs(n, edges));
    }

    private static void twitter() {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        System.out.println(twitter.getNewsFeed(1));
    }

    private static void minStack() {
        MinStack minStack = new MinStack();
        minStack.push(-3);
        minStack.push(0);
        minStack.push(-2);
        minStack.push(-4);
        System.out.println("top " + minStack.getMin()); // return -4
        minStack.pop();
        System.out.println("top " + minStack.top()); // return -2
        System.out.println("min " + minStack.getMin()); // return -3
    }

    private static void maxSlidingWindow() {
        int[] arrays = new int[] {1,3,-1,-3,5,3,6,7};
        System.out.println("max sliding window: " + Arrays.toString(SlidingWindowMaximum.maxSlidingWindow(arrays, 3)));
    }

    private static void subsetsII() {
        int[] nums = new int[] {1, 2, 2};
        List<List<Integer>> result = SubsetsII.subsetsWithDup(nums);
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    private static void evaluateRPN() {
        String[] tokens = new String[]{"18"};
        System.out.println("EvaluateRPN " + EvaluateRPN.evalRPN(tokens));
    }

    private static void kCloset() {
        int[][] points = {{3,2},{7,7},{9,-9},{4,-6},{-3,-6}};
        int k = 4;
        System.out.println("K closet to the origin \n");
        int[][] result = KCloset.kClosest(points, k);
        for (int i=0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static void kFrequentWords() {
        String[] words = new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"};
        int k = 4;
        System.out.println("k frequent words " + TopKFrequentWords.topKFrequent(words, k));
    }

    private static void mapSum() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println("All keys in tries");
        for (String k: mapSum.keys()) {
            System.out.println(k);
        }
        System.out.println(mapSum.sum("ap"));           // return 3 (apple = 3)
        mapSum.insert("app", 2);
        for (String k: mapSum.keys()) {
            System.out.println(k);
        }
        mapSum.insert("appplepen", 7);
        System.out.println(mapSum.sum("ap"));           // return 5 (apple + app = 3 + 2 = 5)
    }

    private static void replaceWords() {
        List<String> dictionary = List.of("e","k","c","harqp","h","gsafc","vn","lqp","soy","mr","x","iitgm","sb","oo","spj","gwmly","iu","z","f","ha","vds","v","vpx","fir","t","xo","apifm","tlznm","kkv","nxyud","j","qp","omn","zoxp","mutu","i","nxth","dwuer","sadl","pv","w","mding","mubem","xsmwc","vl","farov","twfmq","ljhmr","q","bbzs","kd","kwc","a","buq","sm","yi","nypa","xwz","si","amqx","iy","eb","qvgt","twy","rf","dc","utt","mxjfu","hm","trz","lzh","lref","qbx","fmemr","gil","go","qggh","uud","trnhf","gels","dfdq","qzkx","qxw");
        String sentence = "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp";
        System.out.println(ReplaceWords.replaceWords(dictionary, sentence));
    }

    private static void removeDuplicatedCharacters() {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(RemoveAdjacentDuplicate.removeDuplicates(s, k));
    }

    private static void rotateList() {
        int[] array = {1, 2, 3, 4, 5};
        ListNode head = fromArray(array);
        System.out.println("rotate list " + RotateList.rotateRight(head, 2));
    }

    private static void splitLinkedListInParts() {
        int[] array = {1,2,3};
        ListNode head = fromArray(array);
        int k = 5;
        System.out.println("Split linked list in parts" + Arrays.toString(SplitLinkedListInParts.splitListToParts(head, k)));
    }

    private static void oddEvenLinkedList() {
        int[] array = {1,2,3,4,5};
        ListNode head = fromArray(array);
        System.out.println("Odd even linkedlist" + OddEvenLinkedList.oddEvenList(head));
    }

    private static void maxProfitII() {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println("max profit: " + MaxProfitII.maxProfit(prices));
    }

    private static void zigzagBST() {
        List<Integer> arr = Arrays.asList(1,2,3,4,null,null,5);
        TreeNode root = TreeNode.initBinaryTree(arr);
        System.out.println("zigzag order " + BinaryTreeZigzag.zigzagLevelOrder(root));
    }

    private static void optimalPartitionOfString() {
        String s = "abacaba";
        System.out.println("Optimal partition of " + s + " is " + OptimalPartition.partitionString(s));
    }

    private static void partitionDisjoint() {
        int[] arr = new int[]{3,1,8,4,9,7,12,0,0,12,6,12,6,19,24,90,87,54,92};
//        int[] arr = new int[]{24,11,49,80,63,8,61,22,73,85};
        System.out.println("Left size " + PartitionDisjoint.partitionDisjoint(arr));
    }

    private static void deleteMiddleOfLinkedList() {
        int[] arr = {1,3,4,7,1,2,6};
        ListNode head = fromArray(arr);
        System.out.println("Delete middle of linked list " + DeleteMiddle.deleteMiddle(head));
    }

    private static void coloringBorder() {
        int[][] grid = new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        int row = 1, col = 1, color = 2;
        System.out.println("Coloring border output: " + Arrays.deepToString(ColoringBorder.colorBorder(grid, row, col, color)));
    }

    private static void zeroOneMatrix() {
        int[][] matrix = new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {1,0,1,0,1,1,1,1,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}};
//        int[][] matrix = new int[][]{{0,0,0},{1,1,1},{1,1,1}};
        System.out.println("Coloring border output: " + Arrays.deepToString(ZeroOneMatrix.updateMatrix(matrix)));

    }

    private static void insertInterval() {
//        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] intervals = new int[][]{{1,5}};
        int[] newInterval = new int[]{2,3};

        System.out.println("Merge interval: " + Arrays.deepToString(InsertInterval.insert(intervals, newInterval)));
    }

    private static void courseSchedule() {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
//        int[][] prerequisites = new int[][]{};
        System.out.println("Course schedule: " + Arrays.toString(CourseScheduleII.findOrder(numCourses, prerequisites)));
    }

    private static void maxConsecutiveOnesIII() {
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Max consecutive ones: " + MaxConsecutiveOnesIII.longestOnes(nums, k));
    }

    private static void numSubarraysWithSum() {
//        int[] nums = new int[]{0,0,0,0,0};
        int[] nums = new int[]{1,0,1,0,1};
        int k = 2;
        System.out.println("Max consecutive ones: " + NumSubArraysWithSum.numSubarraysWithSum(nums, k));
    }

    private static void minSubArrayLen() {
//        int[] nums = new int[]{1,1,1,1,1,1,1,1};
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println("Minimum sub array Length: " + MinSubArrayLen.minSubArrayLen(target, nums));
    }

    private static void fruitIntoBaskets() {
        int[] fruits = new int[]{2,0,0,2,1,3};
        System.out.println("Fruit into baskets: " + FruitIntoBaskets.totalFruit(fruits));
    }

    private static void balancedString() {
        String s = "WWEQERQWQWWRWWERQWEQ";
//        String s = "WERQ";
        System.out.println("Minimum length of the substring that can be replaced: " + BalancedString.balancedString(s));
    }

    private static void numberOfSubstrings() {
        String s = "abcabc";
//        String s = "WERQ";
        System.out.println("Number of substrings containing at least one occurrence of all these characters a, b and c: "
                + NumberOfSubstrings.numberOfSubstrings(s));
    }

    private static void numberOfSubarrays() {
        int[] nums = new int[]{1,1,2,1,1};
        int k = 3;
        System.out.println("Number of nice sub-arrays: " + NumberOfSubArrays.numberOfSubarrays(nums, k));
    }

    private static void shortestSubArray() {
        int[] nums = new int[]{84,-37,32,40,95};
        int k = 167;
        System.out.println("Shortest sub array: " + ShortestSubArray.shortestSubarray(nums, k));
    }

    private static void intervalIntersection() {
//        int[][] firstList = new int[][]{{0,2},{5,10},{13,23},{24,25}};
        int[][] firstList = new int[][]{{14,16}};
//        int[][] firstList = new int[][]{{1,3},{5,9}};
        int[][] secondList = new int[][]{{7,13},{16,16}};
//        int[][] secondList = new int[][]{};
        System.out.println("Shortest sub array: " +
                Arrays.deepToString(IntervalIntersection.intervalIntersection(firstList, secondList)));
    }

    private static void findAnagrams() {
        String s = "abacbabc";
        String p = "abc";
        System.out.println("Find All Anagrams in a String: " + FindAnagrams.findAnagrams(s, p));
    }

    private static void longestWord() {
        String[] words = new String[]{"a","banana","app","appl","ap","apply","apple"};
        System.out.println("Longest word in dictionary is: " + LongestWordInDictionary.longestWord(words));
    }

    private static void lengthOfLongestSubstring() {
        String word = "abcabcbb";
        System.out.println("Longest substring without repeating characters is: " + LongestSubstring.lengthOfLongestSubstring(word));
    }

    private static void wordSearch() {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][] board = new char[][]{{'C','A','A'},{'A','A','A'},{'B','C','D'}};
        String word = "ABCESEEEFS";
        System.out.println("Is the word " + word + " exist in dictionary: " + WordSearch.exist(board, word));
    }

    private static void minimumCardPickup() {
        int[] cards = new int[]{1,0,5,3};
        System.out.println("minimum card pickup " + MinimumConsecutiveCards.minimumCardPickup(cards));
    }

    private static void maximumUniqueSubarray() {
        int[] nums = new int[]{4,2,4,5,6};
        System.out.println("maximum score " + MaximumErasureValue.maximumUniqueSubarray(nums));
    }

    private static void minimumEffortPath() {
        int[][] heights = new int[][]{{1,2,2},{3,8,2},{5,3,5}};
        System.out.println("maximum score " + PathWithMinimumEffort.minimumEffortPath(heights));
    }

    private static void shortestPathWithObstaclesElimination() {
//        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0,0,0}, {0,1,1,1,1,1,1,1,1,0},
//                {0,1,0,0,0,0,0,0,0,0},{0,1,0,1,1,1,1,1,1,1}, {0,1,0,0,0,0,0,0,0,0},
//                {0,1,1,1,1,1,1,1,1,0},{0,1,0,0,0,0,0,0,0,0}, {0,1,0,1,1,1,1,1,1,1},
//                {0,1,0,1,1,1,1,0,0,0},{0,1,0,0,0,0,0,0,1,0}, {0,1,1,1,1,1,1,0,1,0},
//                {0,0,0,0,0,0,0,0,1,0}};
//        int[][] grid = new int[][]{{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int[][] grid = new int[][]{{0, 1}, {1, 1}, {0, 0}};
        int k = 2;
        System.out.println("shortest path " + ShortestPathWithObstacleElimination.shortestPath(grid, k));
    }

    private static void minPathSum() {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println("Minimum path sum " + MinimumPathSum.minPathSum(grid));
    }

    private static void pathSumIII() {
//        List<Integer> arr = Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null, null,null, null,5,1);
//        TreeNode root = TreeNode.initBinaryTree(arr);
//        int target = 22;
//
//        System.out.println("Number of path " + PathSumIII.pathSum(root, target));
    }

    private static void minCostRobotReturnHome() {
        int[] startPos = {0, 0};
        int[] homePos = {2, 3};
        int[] rowCosts = {5, 4, 3};
        int[] colCosts = {8, 2, 6, 7};
        System.out.println("Minimum path cost " + MinimumCostHomeComingRobot.minCost(startPos,
                homePos, rowCosts, colCosts));
    }

    private static void searchInRotatedSortedArray() {
        int[] nums = new int[]{4,4,4,4,1,4};
        int target = 1;
        System.out.println("index of target " + target + " is " + SearchInRotatedSortedArrayII.search(nums, target));
    }

    private static void findMinInRotatedSortedArray() {
        int[] nums = new int[]{3,3,3,3,3,3,3,3,1,3};
        System.out.println("Min of the array is " + FindMinInRotatedSortedArrayII.findMin(nums));
    }

    private static void lowestCommonAncestor() {
        List<Integer> arr = Arrays.asList(3,5,1,6,2,0,8,null,null,7,4);
        TreeNode root = TreeNode.initBinaryTree(arr);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);

        System.out.println("Lowest common ancestor " + LowestCommonAncestorBT.lowestCommonAncestor(root, p, q));
    }

    private static void getDirections() {
        List<Integer> arr = Arrays.asList(5,1,2,3,null,6,4);
//        List<Integer> arr = Arrays.asList(2,1,0);
        TreeNode root = TreeNode.initBinaryTree(arr);
        int start = 3;
        int dest = 4;

        System.out.println("Lowest common ancestor " + StepByStepDirectionsBT.getDirections(root, start, dest));
    }

    private static void searchRange() {
        int[] nums = new int[]{1,2,3};
        int target = 3;
//        System.out.println("Search of " + target + " in range is " + Arrays.toString(SearchRange.searchRange(nums, target)));
        System.out.println("Search of " + target + " in range is " + SearchInRotatedSortedArray.search(nums, target));
    }

    private static void trimBST() {
        List<Integer> arr = Arrays.asList(3,1,4,null,2);
        TreeNode root = TreeNode.initBinaryTree(arr);
        int low = 1;
        int high = 2;

        System.out.println("Trim BST " + TreeNode.println(TrimBST.trimBST(root, low, high)));
    }

    private static void orangesRotting() {
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
//        int[][] grid = new int[][]{{0,2}};

        System.out.println("Total minutes: " + RottingOranges.orangesRotting(grid));
    }

    private static void combinationSum() {
        int[] candidates = new int[] {7,3,2};
        int target = 18;
        List<List<Integer>> result = CombinationSum.combinationSum(candidates, target);
        System.out.println("size=" + result.size());
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

}
