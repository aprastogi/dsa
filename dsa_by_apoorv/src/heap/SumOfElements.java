package heap;

public class SumOfElements {

    public static int sumOfElements(int [] arr, int k1, int k2){
        int sum = 0;
        int k1Smallest = KthSmallestElement.kthSmallestElement(arr, k1);
        int k2Smallest = KthSmallestElement.kthSmallestElement(arr, k2);
        for(int element : arr){
            if(element > k1Smallest && element < k2Smallest){
                sum += element;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int [] arr = {1,3,12,5,15,11};
        int k1 = 3;
        int k2 = 6;
        System.out.println("Sum of element greater than k1Smallest and less than k2Smallest is : " + sumOfElements(arr, k1, k2));
    }
}
