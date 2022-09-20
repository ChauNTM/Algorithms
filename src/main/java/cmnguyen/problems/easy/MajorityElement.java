package main.java.cmnguyen.problems.easy;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i=1; i < nums.length; i++) {
            if (count == 0) majority = nums[i];
            count += majority == nums[i] ? 1: -1;
        }

        return majority;
    }
}
