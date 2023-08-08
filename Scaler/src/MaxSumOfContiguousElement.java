/* Given an array, Find the max sum of contiguous element (Kadane's algorithm)*/
public class MaxSumOfContiguousElement {

    public static void main(String[] args) {
        int [] arr = {-2,3,4,-1,5,-10,7};
        System.out.println("Max sum is :: " + maxSum(arr));
    }

    private static int maxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : arr) {
            sum += num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
