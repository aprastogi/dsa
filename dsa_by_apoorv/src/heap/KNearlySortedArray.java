package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KNearlySortedArray {
    public static void kNearlySortedArray(int [] arr, int k){
        int ndx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int element : arr){
            pq.add(element);
            // If pq has more elements than k then remove the element from priority queue
            if(!pq.isEmpty() && pq.size() > k) {
                arr[ndx++] = pq.poll();
            }
        }
        // get all remaining element from pq and put in the array
        while(pq.size() > 0){
            arr[ndx++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        int [] arr = {6,5,3,2,99,8,10,9};
        int k = 3;
        System.out.println("Array before sorting : " + Arrays.toString(arr));
        kNearlySortedArray(arr,k);
        System.out.println("Array after sorting : " + Arrays.toString(arr));
    }
}
