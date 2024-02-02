package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static int kthLargestElement(int [] arr, int k){
        // Create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int element : arr){
            pq.add(element);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.size() > 0 ? pq.peek() : -1;
    }

    public static void main(String[] args) {
        int [] arr = {3,7,1,9,2,10,32};
        int k = 3;
        System.out.println(k +"th Largest element is : "+ kthLargestElement(arr,k));
    }
}
