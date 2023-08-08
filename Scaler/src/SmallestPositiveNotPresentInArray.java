/* Given an array of size N, Find the smallest positive no, which is not present in the array */
public class SmallestPositiveNotPresentInArray {
    public static void main(String[] args) {
        int [] arr = {7,2,-3,6,1,4};
        System.out.println("Smallest missing positive number is :: " + smallestMissingPositiveNumber(arr));
    }

    private static int smallestMissingPositiveNumber(int[] arr) {
        int n = arr.length;
        boolean isOneAvailable = false;
        for(int num : arr){
            if(num == 1){
                isOneAvailable = true;
                break;
            }
        }
        if(!isOneAvailable)
            return 1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < 0 || arr[i] > n){
                arr[i] = 1;
            }
        }
        for(int i=0;i<n;i++){
            arr[arr[i] - 1] = arr[i] + n;
        }
        for(int i=0;i<n;i++){
            if(arr[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}
