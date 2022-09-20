package main.java.cmnguyen.problems.medium.two_pointers;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * */
public class ContainerMostWater {

    public static int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int result = 0;
        int current = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                current = height[left] * (right - left);
                left++;
            } else {
                current = height[right] * (right - left);
                right--;
            }
            result = Math.max(result, current);
        }
        return result;
    }

}
