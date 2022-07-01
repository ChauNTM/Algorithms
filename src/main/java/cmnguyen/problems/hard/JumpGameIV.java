package main.java.cmnguyen.problems.hard;

import java.util.Hashtable;

public class JumpGameIV {
    public static int minJumps(int[] arr) {
        Hashtable<Integer, Integer> minSteps = new Hashtable<>();
        int currentStep = 0;
        minSteps.put(arr[0], 0);
        for (int i=1; i < arr.length; i++) {
            currentStep++;
            if (!minSteps.containsKey(arr[i])) {
                minSteps.put(arr[i], currentStep);
            } else {
                int minStep = minSteps.get(arr[i]) + 1;
                if (minStep <= currentStep) currentStep = minStep;
                else minSteps.put(arr[i], currentStep);
            }
            int j = i - 1;
            int curr = currentStep + 1;
            while(minSteps.containsKey(arr[j]) && minSteps.get(arr[j]) > curr) {
                minSteps.put(arr[j--], curr++);
            }
        }
        return currentStep;
    }
}
