/* Given an array of size N, Find the smallest positive no, which is not present in the array */
public class SmallestPositiveNotPresentInArray {
    public static void main(String[] args) {
        int [] arr = {7,2,-3,6,1,4};
        System.out.println("Smallest missing positive number is :: " + smallestMissingPositiveNumber(arr));
    }

    private static int smallestMissingPositiveNumber(int[] arr) {
        int n = arr.length;
        boolean isOneAvailable = false;

        // Check if 1 is present in array or not
        for(int num : arr){
            if(num == 1){
                isOneAvailable = true;
                break;
            }
        }

        // If 1 is not present
        if(!isOneAvailable)
            return 1;

        // Changing values to 1
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= 0 || arr[i] > n){
                arr[i] = 1;
            }
        }

        // Updating indices according to values
        for(int i=0;i<n;i++){
            arr[(arr[i] - 1) % n] +=  n;
        }

        // Finding which index has value less than n
        for(int i=0;i<n;i++){
            if(arr[i] <=n)
                return i + 1;
        }
        return n + 1;
    }
}
