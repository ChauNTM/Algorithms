package main.java.cmnguyen.problems.medium.sliding_window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfSubArrays {

    public static int numberOfSubarrays(int[] nums, int k) {
        int i = 0;
        int count = 0;
        int start = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] % 2 != 0) k--;

            // only numbers which are between 2 start index of 2 continuous valid windows are even numbers
            if (k <= 0) start = i;
            while (k <= 0) {
                if (nums[i++] % 2 != 0) k++;
            }
            count += i - start;
        }

        return count;
    }

}
