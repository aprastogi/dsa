
/* Given an array & Q queries of range(L,R), find the sum of the subarray from L to R */
public class SumOfSubarrayLToR {

    public static void main(String[] args) {
        int [] arr = {6,12,20,30,42,51,63,80,90,105};
        int [][] queries = {{6,9}};
        for(int [] query : queries){
            int l = query[0];
            int r = query[1];
            System.out.println("Sum of subarray for range (" + l + "," + r + ") is :: " + findSum(arr, l, r));
        }
    }

    private static int findSum(int[] arr, int l, int r) {
        int n = arr.length;
        int [] prefix = new int[n];
        prefix[0] = arr[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i];
        }
        if(l > 0)
            return prefix[r] - prefix[l-1];
        return prefix[r];
    }
}
