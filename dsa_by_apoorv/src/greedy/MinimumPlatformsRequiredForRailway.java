package greedy;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
 */
public class MinimumPlatformsRequiredForRailway {

    public static int minimumPlatformsRequiredForRailway(int [] arr, int [] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        // store the platform needed at current moment
        int platform = 1;
        // store the total platform needed till now
        int answer = 0;
        int i = 0, j= 1;
        while(i < arr.length && j < dep.length){
            if(arr[j] <= dep[i]){
                // If arrival of upcoming train is before the departure of current train, increment the platform
                platform++;
                j++;
            } else{
                // If arrival of upcoming train is after the departure of current train, decrement the platform
                platform--;
                i++;
            }
            answer = Math.max(answer, platform);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = { 100, 300, 500 };
        int[] dep = { 900, 400, 600 };
        System.out.println(minimumPlatformsRequiredForRailway(arr, dep));
    }
}
