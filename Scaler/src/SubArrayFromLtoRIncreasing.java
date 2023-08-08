
/* Given an array of size N & given q queries of L & R. return true if the subarray from L to R is increasing */
public class SubArrayFromLtoRIncreasing {
    public static void main(String[] args) {
        int [] arr = {1,4,4,7,6,8,2,10,20,21};
        int [][] queries = {{6,9},{3,5},{4,5}};
        for(int [] query : queries){
            int l = query[0];
            int r = query[1];
            System.out.println("Subarray for range (" + l + "," + r + ") is :: " + (findSum(arr, l, r) ? "increasing" : "not increasing"));
        }
    }

    private static boolean findSum(int[] arr, int l, int r) {
        int n = arr.length;
        int [] prefix = new int[n];
        int [] tmpPrefix = new int[n];
        for(int i=1;i<n;i++){
            if(arr[i] < arr[i-1]){
                prefix[i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            tmpPrefix[i] = tmpPrefix[i-1] + prefix[i];
        }
        return tmpPrefix[r] - tmpPrefix[l] == 0;
    }
}
