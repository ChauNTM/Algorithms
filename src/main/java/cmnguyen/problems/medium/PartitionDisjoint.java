package main.java.cmnguyen.problems.medium;

public class PartitionDisjoint {

    public static int partitionDisjoint(int[] nums) {
        int maxLeft = nums[0];
        int maxRight = maxLeft;
        int leftLength = 0;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] < maxLeft) {
                leftLength = i;
                maxLeft = maxRight;
            } else if (nums[i] > maxRight) {
                maxRight = nums[i];
            }
        }

        return leftLength + 1;
    }
}
