package sliding_window.fixed;

public class MaximumSumOfAllSubarrayOfSizeK {
    public static void main(String[] args) {
        int [] arr = {1,4,2,10,23,3,1,0,20};
        int k = 4;
        System.out.println(maxSumOfAllSubArray(arr, k));
    }

    private static int maxSumOfAllSubArray(int[] arr, int k) {
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0;
        // contain max among all subarray
        int max = Integer.MIN_VALUE;
        while(j < n){
            sum = sum + arr[j];
            int currentWindow = j - i + 1;
            // If we have lesser element than window size increment j pointer
            if(currentWindow < k){
                j++;
            }
            // If we have hit the k window size
            else if(currentWindow == k){
                max = Math.max(max, sum);
                // reduce ith pointer value from sum as we need to slide the window by 1
                sum = sum - arr[i];
                // Slide the window
                i++;
                j++;
            }
        }
        return max;
    }
}
