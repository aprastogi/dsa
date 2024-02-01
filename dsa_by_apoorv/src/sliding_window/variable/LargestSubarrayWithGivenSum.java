package variable;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/longest-sub-array-sum-k/
Given an array arr[] of size n containing integers. The problem is to find the length of the longest sub-array having sum equal to the given value k.
 */

public class LargestSubarrayWithGivenSum {
    public static void main(String[] args) {
        int [] arr = {10,5,2,7,1,9};
        int sum = 15;
        System.out.println(Arrays.toString(largestSubarrayWithGivenSum(arr, sum)));
    }

    private static int [] largestSubarrayWithGivenSum(int[] arr, int target) {
        int i = 0, j = 0;
        int n = arr.length;
        int sum = 0;
        int start = -1, end = -1;
        int maxWindow = Integer.MIN_VALUE;
        while(j < n){
            // Calculate the current sum
            sum = sum + arr[j];
            // whenever sum equal to target store the probable answer with the current window
            if(sum == target){
                int currentWindow = j - i + 1;
                if(maxWindow < currentWindow){
                    maxWindow = currentWindow;
                    start = i;
                    end = j;
                }
            }
            // whenever we get a sum greater than the required target we will slide the window from left till sum is greater that target
            else if(sum > target){
                while(i < j && sum > target){
                    sum = sum - arr[i];
                    i++;
                }
            }
            j++;
        }
        if(start == -1)
            return new int[]{};
        return new int[]{start, end};
    }
}
