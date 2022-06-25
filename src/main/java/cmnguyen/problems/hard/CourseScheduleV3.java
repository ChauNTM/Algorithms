package main.java.cmnguyen.problems.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are n different online courses numbered from 1 to n. You are given an array courses where
 * courses[i] = [durationi, lastDayi] indicate that the ith course should be taken continuously for
 * durationi days and must be finished before or on lastDayi.
 * You will start on the 1st day and you cannot take two or more courses simultaneously.
 *
 * Return the maximum number of courses that you can take.
 * */
public class CourseScheduleV3 {

    private static class MaxHeap<T extends Comparable<T>> {
        // items are hold from 1 to n
        T[] a;
        int n;

        public MaxHeap(int maxN) {
            a = (T[]) new Comparable[maxN];
            n = 0;
        }

        public void insert(T item) {
            a[++n] = item;
            swim(n);
        }

        public T deleteMax() {
            exchange(1, n);
            T item = a[n];
            a[n] = null;
            n--;
            sink(1);
            return item;
        }

        private void sink(int k) {
            while (2*k < n) {
                int i = 2*k;
                if (2*k < n && greater(i+1, i)) i++;
                if (greater(k, i)) break;
                exchange(k, i);
                k = i;
            }
        }

        private void swim(int k) {
            while(k > 1 && greater(k, k/2)) {
                exchange(k, k/2);
                k = k/2;
            }
        }

        private boolean greater(int i, int j) {
            return a[i].compareTo(a[j]) > 0;
        }

        private void exchange(int i, int j) {
            T temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        public int size() {
            return n;
        }

        public String toString() {
            return Arrays.toString(a);
        }
    }

    public static int scheduleCourse(int[][] courses) {
        /*
         * sort courses by lastday
         * */
        Arrays.sort(courses, Comparator.comparingInt(course -> course[1]));
        MaxHeap<Integer> heap = new MaxHeap<>(courses.length + 1);

        int total = 0;
        for (int[] course: courses) {
            heap.insert(course[0]);
            total += course[0];
            if (total > course[1]) {
                total -= heap.deleteMax();
            }
        }
        return heap.size();
    }

}
